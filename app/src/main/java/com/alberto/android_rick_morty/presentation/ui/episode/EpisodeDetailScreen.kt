package com.alberto.android_rick_morty.presentation.ui.episode

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alberto.android_rick_morty.presentation.navigation.Route
import com.alberto.android_rick_morty.presentation.ui.components.Header
import com.alberto.android_rick_morty.presentation.ui.components.ItemDetails
import com.alberto.android_rick_morty.presentation.ui.episode.components.EpisodeItems
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
                EpisodeItems(
                    items = listOf("nombre: Pilot", "salida: December 2, 2013", "episodio: S01E01")
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