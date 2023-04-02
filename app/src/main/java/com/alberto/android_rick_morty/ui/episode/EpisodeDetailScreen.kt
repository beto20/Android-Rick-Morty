package com.alberto.android_rick_morty.ui.episode

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alberto.android_rick_morty.navigation.Route
import com.alberto.android_rick_morty.ui.components.Header
import com.alberto.android_rick_morty.ui.components.ItemDetails
import com.alberto.android_rick_morty.util.UiEvent

@Composable
fun EpisodeDetailScreen(
    onNavigate: (UiEvent.Navigate) -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(3.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Header(
                title = "Episodios",
                navigateTo = { onNavigate(UiEvent.Navigate(Route.EPISODE)) }
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        vertical = 4.dp,
                        horizontal = 20.dp
                    )
            ) {
                Text(
                    text = "nombre: Pilot",
                    color = Color.Green,
                    fontSize = 28.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "salida: December 2, 2013",
                    color = Color.Green,
                    fontSize = 28.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "episodio: S01E01",
                    color = Color.Green,
                    fontSize = 28.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Medium
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 300.dp)
        ) {
            ItemDetails(
                title = "PERSONAJES",
                items = listOf("https://...", "https://...", "https://...")
            )
        }
    }
}

@Preview
@Composable
fun EpisodeDetailScreenPreview() {
    EpisodeDetailScreen({ })
}