package com.martinbove.paging3compose.presentation.beerDetails.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.martinbove.paging3compose.presentation.theme.ComposePaging3CachingTheme

/**
 * Created by Martín Bove on 02/08/2023.
 * E-mail: mbove77@gmail.com
 */

@Composable
fun BrewersTips(tip: String) {
    Column(Modifier.padding(16.dp)) {
        Text(
            text = tip,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Preview(showBackground = true, name = "Light Theme")
@Preview(showBackground = true, name = "Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BeerTipsPreview() {
    ComposePaging3CachingTheme {
        BrewersTips("Primera opcion de comida" )
    }
}