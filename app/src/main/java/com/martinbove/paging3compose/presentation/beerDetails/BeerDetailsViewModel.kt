package com.martinbove.paging3compose.presentation.beerDetails

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.martinbove.paging3compose.data.mappers.toBeer
import com.martinbove.paging3compose.data.remote.BeerApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

/**
 * Created by Martín Bove on 29/07/2023.
 * E-mail: mbove77@gmail.com
 */

@HiltViewModel
class BeerDetailsViewModel @Inject constructor(private val beerApi: BeerApi) : ViewModel() {

    var state by mutableStateOf(BeerDetailsState())
        private set

    fun getBeer(beerId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            state = state.copy(
                isLoading = true,
                beerData = null,
                error = null
            )

            try {
                delay(300)
                val result = beerApi.getBeer(beerId.toInt())

                state = state.copy(
                    isLoading = false,
                    beerData = result.first().toBeer(),
                    error = null,
                )
            } catch (e: IOException) {
                Log.e(BEER_API_TAG, e.message.toString())
                state = state.copy(
                    isLoading = false,
                    beerData = null,
                    error = e.message,
                )
            } catch (e: HttpException) {
                Log.e(BEER_API_TAG, e.message.toString())
                state = state.copy(
                    isLoading = false,
                    beerData = null,
                    error = e.message,
                )
            }
        }
    }

    companion object {
        const val BEER_API_TAG = "BeerApiError"
    }
}
