package com.plcoding.composepaging3caching.presentation.beerDetails

import com.plcoding.composepaging3caching.domain.model.Beer

/**
 * Created by Martín Bove on 02/08/2023.
 * E-mail: mbove77@gmail.com
 */

data class BeerDetailsState(
    val beerData: Beer? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
