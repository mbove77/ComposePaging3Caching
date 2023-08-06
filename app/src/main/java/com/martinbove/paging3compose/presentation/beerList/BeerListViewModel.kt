package com.martinbove.paging3compose.presentation.beerList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.martinbove.paging3compose.data.local.BeerEntity
import com.martinbove.paging3compose.data.mappers.toBeer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by Martín Bove on 28/07/2023.
 * E-mail: mbove77@gmail.com
 */

@HiltViewModel
class BeerListViewModel @Inject constructor(
    pager: Pager<Int, BeerEntity>
): ViewModel() {

    val beerPagingFlow = pager.flow.map { pagingData ->
        pagingData.map {
            it.toBeer()
        }
    }.cachedIn(viewModelScope)


}