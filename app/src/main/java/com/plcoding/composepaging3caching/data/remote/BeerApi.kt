package com.plcoding.composepaging3caching.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Martín Bove on 28/07/2023.
 * E-mail: mbove77@gmail.com
 */

interface BeerApi {
    @GET("beers")
    suspend fun getBeers(
        @Query("page") page: Int,
        @Query("per_page") pageCount: Int
    ): List<BeerDto>

    @GET("beers/{beer_id}")
    suspend fun getBeer(
        @Path("beer_id") beerId: Int,
    ):  List<BeerDetailsDto>

    companion object {
        const val BASE_URL = "https://api.punkapi.com/v2/"
    }
}