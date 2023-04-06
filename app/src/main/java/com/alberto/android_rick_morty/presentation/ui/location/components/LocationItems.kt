package com.alberto.android_rick_morty.presentation.ui.location.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun LocationItems(
    items: List<String>
) {
    items.forEach {
        Text(
            text = it,
            color = Color.Green,
            fontSize = 28.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview
@Composable
fun LocationItemsPreview() {
    LocationItems(
        items = listOf("nombre: Tierra", "tipo: Planeta", "dimension: Dimension C-137")
    )
}