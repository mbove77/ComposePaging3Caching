package com.plcoding.composepaging3caching.presentation.beerDetails.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plcoding.composepaging3caching.presentation.theme.ComposePaging3CachingTheme

/**
 * Created by Martín Bove on 02/08/2023.
 * E-mail: mbove77@gmail.com
 */

@Composable
fun BeerCard(tittle: String, content: @Composable () -> Unit) {
    Column {
        Text(
            text = tittle,
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(12.dp))

        Card(Modifier
            .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
        ) {
            content()
        }
    }
}

@Preview(showBackground = true, name = "Light Theme")
@Preview(showBackground = true, name = "Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BeerCardPreview() {
    ComposePaging3CachingTheme {
        BeerCard("Primera opcion de comida", { BrewersTips(tip = "esto es un tip muy loco")} )
    }
}