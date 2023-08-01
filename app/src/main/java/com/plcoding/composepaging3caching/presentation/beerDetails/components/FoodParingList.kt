package com.plcoding.composepaging3caching.presentation.beerDetails.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plcoding.composepaging3caching.presentation.theme.ComposePaging3CachingTheme

/**
 * Created by Martín Bove on 31/07/2023.
 * E-mail: mbove77@gmail.com
 */
@Composable
fun FoodParingList(foodParingList: List<String>) {
    Column {
        Text(
            text = "Food parings",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(12.dp))

        Card(Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
        ) {

            Column() {

                foodParingList.forEachIndexed { index, foodParing ->

                    Column(
                        Modifier.padding(8.dp, 12.dp)
                    ) {
                        Text(
                            text = foodParing,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                    if (index < foodParingList.lastIndex)
                        Divider(
                            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.09f),
                            thickness = 1.dp, modifier = Modifier.padding(8.dp, 4.dp)
                        )
                }
            }
        }

    }
}

@Preview(showBackground = true, name = "Light Theme")
@Preview(showBackground = true, name = "Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BeerItemPreview() {
    ComposePaging3CachingTheme {
        FoodParingList(
            listOf(
                "Primera opcion de comida",
                "Segunda opcion de acompañamiento",
                "Ultima opcion interesante."
            )
        )
    }
}