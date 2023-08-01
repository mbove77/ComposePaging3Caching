package com.plcoding.composepaging3caching.domain.model

/**
 * Created by Martín Bove on 31/07/2023.
 * E-mail: mbove77@gmail.com
 */

data class BeerDetails(
    val foodPairing: List<String>,
    val brewersTips: String?,
    val abv: Float?,
    val ibu: Float?,
    val targetFg: Float?,
    val targetOg: Float?,
    val ebc: Float?,
    val srm: Float?,
    val ph: Float?,
    val attenuationLevel: Float?
)
