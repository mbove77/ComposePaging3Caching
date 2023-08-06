package com.martinbove.paging3compose.presentation.navigation

/**
 * Created by Martín Bove on 29/07/2023.
 * E-mail: mbove77@gmail.com
 */

sealed class Screen(val route: String) {
    object BeerList : Screen("beer_list_screen")
    object BeerDetails : Screen("beer_details_screen/{beer_id}") {
        fun createRoute(beerId: Int) = "beer_details_screen/$beerId"
    }
}
