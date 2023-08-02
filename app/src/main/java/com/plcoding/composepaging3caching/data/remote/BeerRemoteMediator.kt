package com.plcoding.composepaging3caching.data.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.plcoding.composepaging3caching.data.local.BeerDatabase
import com.plcoding.composepaging3caching.data.local.BeerEntity
import com.plcoding.composepaging3caching.data.mappers.toBeerEntity
import okio.IOException
import retrofit2.HttpException

/**
 * Created by Martín Bove on 28/07/2023.
 * E-mail: mbove77@gmail.com
 */

@OptIn(ExperimentalPagingApi::class)
class BeerRemoteMediator(private val beerDB: BeerDatabase, private val beerApi: BeerApi):
    RemoteMediator<Int, BeerEntity>() {

    override suspend fun load(loadType: LoadType, state: PagingState<Int, BeerEntity>): MediatorResult {
        return try {
            val loadKey = when(loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> {
                    return MediatorResult.Success(
                        endOfPaginationReached = true
                    )
                }
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if(lastItem == null) {
                        1
                    } else {
                        (lastItem.id / state.config.pageSize) + 1
                    }
                }
            }

            val beers = beerApi.getBeers(loadKey, state.config.pageSize)

            beerDB.withTransaction {
                if(loadType == LoadType.REFRESH) {
                    beerDB.dao.clearAll()
                }

                val beerEntities = beers.map { it.toBeerEntity() }

                beerDB.dao.upsertAll(beerEntities)
            }

            MediatorResult.Success(
                endOfPaginationReached = beers.isEmpty()
            )

        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }

    }

}