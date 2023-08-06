package com.martinbove.paging3compose.presentation.beerDetails.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martinbove.paging3compose.domain.model.BeerDetails
import com.martinbove.paging3compose.presentation.theme.AppTheme

/**
 * Created by Martín Bove on 01/08/2023.
 * E-mail: mbove77@gmail.com
 */

@Composable
fun BeerDetailsInfoGrid(tittle: String, beerDetails: BeerDetails) {
    Column {
        Text(
            text = tittle,
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(Modifier.fillMaxWidth()) {
            Column(Modifier.weight(1f)) {
                InfoItem(name = "Ibu", value = beerDetails.ibu)
            }
            Column(Modifier.weight(1f)) {
                InfoItem(name = "Abv", value = beerDetails.abv)
            }
            Column(Modifier.weight(1f)) {
                InfoItem(name = "Ebc", value = beerDetails.ebc)
            }
        }
        Row(Modifier.fillMaxWidth()) {
            Column(Modifier.weight(1f)) {
                InfoItem(name = "Srm", value = beerDetails.srm)
            }
            Column(Modifier.weight(1f)) {
                InfoItem(name = "Ph", value = beerDetails.ph)
            }
            Column(Modifier.weight(1f)) {
                InfoItem(name = "Attenuation", value = beerDetails.attenuationLevel)
            }
        }
        Row(Modifier.fillMaxWidth()) {
            Column(Modifier.weight(1f)) {
                InfoItem(name = "Target Fg", value = beerDetails.targetFg)
            }
            Column(Modifier.weight(2f)) {
                InfoItem(name = "Target Og", value = beerDetails.targetOg)
            }
        }
    }
}


@Composable
fun InfoItem(name: String, value: Any?) {
    Box(
        Modifier
            .width(130.dp)
            .height(130.dp)
            .aspectRatio(1f)
            .padding(4.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            Modifier
                .padding(4.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Text(
                text = name,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = value?.toString() ?: "n/a",
                style = MaterialTheme.typography.bodyMedium,
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Preview(showBackground = true, name = "Light Theme")
@Preview(showBackground = true, name = "Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BeerDetailsInfoGridPreview() {
    AppTheme {
        BeerDetailsInfoGrid(
            "Beer information",
            BeerDetails(
                listOf(
                    "Primera opcion de comida",
                    "Segunda opcion de acompañamiento",
                    "Ultima opcion interesante."
                ),
                "",
                null,
                null,
                0f,
                0f,
                0f,
                0f,
                0f,
                0f
            )
        )
    }
}