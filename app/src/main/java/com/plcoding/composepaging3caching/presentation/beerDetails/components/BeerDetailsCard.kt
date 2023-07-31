package com.plcoding.composepaging3caching.presentation.beerDetails.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.composepaging3caching.domain.model.Beer

/**
 * Created by Martín Bove on 31/07/2023.
 * E-mail: mbove77@gmail.com
 */
@Composable
fun BeerDetailsCard(beer: Beer) {
    Card(
        Modifier
            .fillMaxWidth(),
        ) {
        Column(
            Modifier.padding(16.dp)
        ) {
            Text(
                text = beer.name,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = beer.tagline,
                style = TextStyle(fontSize = 16.sp)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}