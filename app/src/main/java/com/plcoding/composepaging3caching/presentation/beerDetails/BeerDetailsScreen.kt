package com.plcoding.composepaging3caching.presentation.beerDetails


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.plcoding.composepaging3caching.presentation.theme.ComposePaging3CachingTheme

/**
 * Created by Martín Bove on 29/07/2023.
 * E-mail: mbove77@gmail.com
 */

@Composable
fun BeerDetailsScreen(navController: NavHostController, beerId: String? = null) {
    val context = LocalContext.current

    Text(text = "Se seleciono la cerbeza con id: $beerId",
        Modifier.fillMaxSize(),
        textAlign = TextAlign.Center,
        )
}

@Composable
@Preview
fun previewBeerDetails() {
    ComposePaging3CachingTheme {
        BeerDetailsScreen(rememberNavController())
    }
}