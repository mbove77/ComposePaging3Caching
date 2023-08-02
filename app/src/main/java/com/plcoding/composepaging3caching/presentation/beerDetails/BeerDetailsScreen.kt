package com.plcoding.composepaging3caching.presentation.beerDetails


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.plcoding.composepaging3caching.presentation.beerDetails.components.BeerCard
import com.plcoding.composepaging3caching.presentation.beerDetails.components.BeerDetailsInfoGrid
import com.plcoding.composepaging3caching.presentation.beerDetails.components.BeerDetailsMainInfo
import com.plcoding.composepaging3caching.presentation.beerDetails.components.BrewersTips
import com.plcoding.composepaging3caching.presentation.beerDetails.components.FoodParingList

/**
 * Created by Martín Bove on 29/07/2023.
 * E-mail: mbove77@gmail.com
 */

@Composable
fun BeerDetailsScreen(viewModel: BeerDetailsViewModel, navController: NavHostController) {
    val beer = viewModel.beer.value

    if (beer != null) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {

            BeerDetailsMainInfo(beer = beer)
            Spacer(modifier = Modifier.height(24.dp))

            beer.beerDetails?.let { beerDetail ->
                BeerCard(tittle = "Food parings", content = {
                    FoodParingList(foodParingList = beerDetail.foodPairing)
                })
                Spacer(modifier = Modifier.height(24.dp))
            }

            beer.beerDetails?.brewersTips?.let { brewerTip ->
                BeerCard(tittle = "Brewers Tips", content = {
                    BrewersTips(tip = brewerTip)
                })
                Spacer(modifier = Modifier.height(24.dp))
            }

            beer.beerDetails?.let { beerDetail ->
                BeerDetailsInfoGrid("Beer information", beerDetails = beerDetail)
            }
        }

    } else {
        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    }
}

