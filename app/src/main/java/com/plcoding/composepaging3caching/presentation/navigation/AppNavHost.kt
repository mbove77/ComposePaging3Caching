package com.plcoding.composepaging3caching.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plcoding.composepaging3caching.presentation.beerDetails.BeerDetailsScreen
import com.plcoding.composepaging3caching.presentation.beerDetails.BeerDetailsViewModel
import com.plcoding.composepaging3caching.presentation.beerList.BeerListScreen
import com.plcoding.composepaging3caching.presentation.beerList.BeerListViewModel

/**
 * Created by Martín Bove on 29/07/2023.
 * E-mail: mbove77@gmail.com
 */

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.BeerList.route,
) {
    val beerListviewModel = hiltViewModel<BeerListViewModel>()
    val beerDetailsViewModel = hiltViewModel<BeerDetailsViewModel>()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.BeerList.route) {
            BeerListScreen(beerListviewModel, navController)
        }
        composable(Screen.BeerDetails.route) {
            val beerId = it.arguments?.getString("beer_id")
            if (beerId != null) {
                beerDetailsViewModel.getBeer(beerId)
            }
            BeerDetailsScreen(beerDetailsViewModel, navController)
        }

    }
}