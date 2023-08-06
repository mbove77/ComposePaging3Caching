package com.martinbove.paging3compose.presentation.beerDetails

import com.martinbove.paging3compose.domain.model.Beer

/**
 * Created by Martín Bove on 02/08/2023.
 * E-mail: mbove77@gmail.com
 */

data class BeerDetailsState(
    val beerData: Beer? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
