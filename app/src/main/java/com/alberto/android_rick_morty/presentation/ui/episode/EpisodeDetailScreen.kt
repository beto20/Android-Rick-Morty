package com.alberto.android_rick_morty.presentation.ui.episode

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.alberto.android_rick_morty.presentation.navigation.Route
import com.alberto.android_rick_morty.presentation.ui.components.Header
import com.alberto.android_rick_morty.presentation.ui.components.ItemDetails
import com.alberto.android_rick_morty.presentation.ui.episode.components.EpisodeItems
import com.alberto.android_rick_morty.presentation.viewmodel.EpisodeViewModel
import com.alberto.android_rick_morty.util.UiEvent

@Composable
fun EpisodeDetailScreen(
    episodeId: String?,
    onNavigate: (UiEvent.Navigate) -> Unit
) {
    val viewModel = hiltViewModel<EpisodeViewModel>()
    val state by viewModel.state.collectAsState()
    viewModel.showEpisodeDetails(episodeId)

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
                    items = listOf(
                        "nombre: ${state.episodeSelected?.name}",
                        "salida: ${state.episodeSelected?.airDate}",
                        "episodio: ${state.episodeSelected?.episode}"
                    )
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
                items = state.episodeSelected?.charactersInEpisode
            )
        }
    }
}

@Preview
@Composable
fun EpisodeDetailScreenPreview() {
    EpisodeDetailScreen(
        "1",
        { }
    )
}