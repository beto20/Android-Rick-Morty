package com.alberto.android_rick_morty.ui.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ItemDetails(
    title: String,
    items: List<String>
) {
    Column(
        modifier = Modifier
            .padding(
                vertical = 4.dp,
                horizontal = 20.dp
            )
    ) {
        Text(
            text = title,
            color = Color.Green,
            fontSize = 28.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        items.forEach {
            Text(
                text = "p1: $it",
                color = Color.Green,
                fontSize = 28.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        Toast
                            .makeText(
                                null,
                                " selected $it",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
            )
        }
    }
}

@Preview
@Composable
fun ItemDetailsPreview() {
    ItemDetails(
        title = "Personajes",
        items = listOf("https://...", "https://...", "https://...")
    )
}