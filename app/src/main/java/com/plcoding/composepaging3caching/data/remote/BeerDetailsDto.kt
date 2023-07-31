package com.plcoding.composepaging3caching.data.remote

/**
 * Created by Martín Bove on 31/07/2023.
 * E-mail: mbove77@gmail.com
 */

data class BeerDetailsDto(
    val id: Int,
    val name: String,
    val tagline: String,
    val description: String,
    val first_brewed: String,
    val image_url: String?,
    val food_pairing: List<String>,
    val brewers_tips: String,
    val abv: Float,
    val ibu: Float,
    val target_fg: Float,
    val target_og: Float,
    val ebc: Float,
    val srm: Float,
    val ph: Float,
    val attenuation_level: Float
)
