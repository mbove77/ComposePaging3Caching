package com.plcoding.composepaging3caching.presentation.beerDetails


import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.plcoding.composepaging3caching.domain.model.Beer
import com.plcoding.composepaging3caching.presentation.beerDetails.components.BeerDetailsCard
import com.plcoding.composepaging3caching.presentation.beerList.BeerItem
import com.plcoding.composepaging3caching.presentation.theme.ComposePaging3CachingTheme

/**
 * Created by Martín Bove on 29/07/2023.
 * E-mail: mbove77@gmail.com
 */

@Composable
fun BeerDetailsScreen(viewModel: BeerDetailsViewModel, navController: NavHostController) {
    val beer = viewModel.beer.value

    if (beer != null) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            AsyncImage(
                model = beer.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.5f)
            )

            BeerItem(beer = beer, selectBeerClick = {})
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    }
}

@Preview(showBackground = true, name = "Light Theme")
@Preview(showBackground = true, name = "Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BeerItemPreview() {
    ComposePaging3CachingTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            BeerDetailsCard(beer = Beer(
                1,
                "Cebeza Negra",
                "Una buena Cerbeza",
                "03/2022",
                "Esta es la descripcion de la cerbeza \n " +
                        "Segunda linea de la descripcion de la cerbeza.",
                null,
                null
            ))
        }
    }
}