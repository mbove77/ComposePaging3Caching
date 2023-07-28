package com.plcoding.composepaging3caching.domain.model

/**
 * Created by Martín Bove on 28/07/2023.
 * E-mail: mbove77@gmail.com
 */
data class Beer(
    val id: Int,
    val name: String,
    val tagline: String,
    val firstBrew: String,
    val description: String,
    val imageUrl: String?
)
