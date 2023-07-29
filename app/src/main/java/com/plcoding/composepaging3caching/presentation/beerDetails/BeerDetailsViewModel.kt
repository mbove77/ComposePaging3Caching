package com.plcoding.composepaging3caching.presentation.beerDetails

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.composepaging3caching.data.mappers.toBeer
import com.plcoding.composepaging3caching.data.remote.BeerApi
import com.plcoding.composepaging3caching.domain.model.Beer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

/**
 * Created by Martín Bove on 29/07/2023.
 * E-mail: mbove77@gmail.com
 */

@HiltViewModel
class BeerDetailsViewModel @Inject constructor(private val beerApi: BeerApi): ViewModel() {

    var beer = mutableStateOf<Beer?>(null)
        private set

    fun getBeer(beerId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = beerApi.getBeer(beerId.toInt())
                beer.value = result.first().toBeer()

            } catch (e: IOException) {
                Log.e("BeerApiError", e.message.toString())
            }catch (e: HttpException) {
                Log.e("BeerApiError", e.message.toString())
            }
        }
    }

}