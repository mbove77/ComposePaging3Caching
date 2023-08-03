package com.plcoding.composepaging3caching.presentation.beerList

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.plcoding.composepaging3caching.presentation.navigation.Screen

/**
 * Created by Martín Bove on 28/07/2023.
 * E-mail: mbove77@gmail.com
 */

@Composable
fun BeerListScreen(
    viewModel: BeerListViewModel,
    navController: NavHostController
) {
    val context = LocalContext.current
    val state = viewModel.beerPagingFlow.collectAsLazyPagingItems()

    LaunchedEffect(key1 = state.loadState) {
        if (state.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error" + (state.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        if (state.loadState.refresh is LoadState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(state) { beer ->
                    if (beer != null) {
                        BeerItem(
                            beer = beer,
                            Modifier.fillMaxWidth().padding(16.dp, 0.dp),
                            selectBeerClick = { beerId ->
                                navController.navigate(Screen.BeerDetails.createRoute(beerId))
                            }
                        )
                    }
                }
                item {
                    if (state.loadState.append is LoadState.Loading) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}