package com.alberto.android_rick_morty.presentation.ui.character.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun CharacterItems(
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
fun CharacterItemsPreview() {
    CharacterItems(
        items = listOf("nombre: Rick Sanchez", "estado: Vivo", "especie: Humano", "genero: Masculino", "origen: Tierra")
    )
}