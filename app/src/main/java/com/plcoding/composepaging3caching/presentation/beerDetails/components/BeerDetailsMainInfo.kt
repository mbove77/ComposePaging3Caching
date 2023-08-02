package com.plcoding.composepaging3caching.presentation.beerDetails.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.plcoding.composepaging3caching.domain.model.Beer
import com.plcoding.composepaging3caching.presentation.utils.RotateImgTransformation

/**
 * Created by Martín Bove on 02/08/2023.
 * E-mail: mbove77@gmail.com
 */

@Composable
fun BeerDetailsMainInfo(beer: Beer) {

    val painter =
        rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current).data(data = beer.imageUrl).apply(
                block = fun ImageRequest.Builder.() {
                    transformations(
                        RotateImgTransformation(-90f, beer.name),
                    )
                }).build()
        )

    Card(
        Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),

        ) {
        Column(Modifier.padding(16.dp)) {

          if (beer.imageUrl != null) {
                Image(
                    painter = painter,
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp)
                        .padding(0.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))
            }

            Text(
                text = beer.name,
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = beer.tagline,
                style = MaterialTheme.typography.titleMedium,
                fontStyle = FontStyle.Italic,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = beer.description,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}