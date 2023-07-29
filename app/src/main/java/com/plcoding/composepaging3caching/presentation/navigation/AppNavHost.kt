package com.plcoding.composepaging3caching.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.LazyPagingItems
import com.plcoding.composepaging3caching.domain.model.Beer
import com.plcoding.composepaging3caching.presentation.beerDetails.BeerDetailsScreen
import com.plcoding.composepaging3caching.presentation.beerList.BeerListScreen

/**
 * Created by Martín Bove on 29/07/2023.
 * E-mail: mbove77@gmail.com
 */

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.BeerList.route,
    beers: LazyPagingItems<Beer>
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.BeerList.route) {
            BeerListScreen(beers, navController)
        }
        composable(Screen.BeerDetails.route) {
            val beerId = it.arguments?.getString("beer_id")
            BeerDetailsScreen(navController, beerId = beerId)
        }

    }
}