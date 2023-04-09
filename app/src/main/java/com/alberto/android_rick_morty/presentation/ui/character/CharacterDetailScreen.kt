package com.alberto.android_rick_morty.presentation.ui.character

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.alberto.android_rick_morty.presentation.navigation.Route
import com.alberto.android_rick_morty.presentation.ui.character.components.CharacterItems
import com.alberto.android_rick_morty.presentation.ui.components.Header
import com.alberto.android_rick_morty.presentation.ui.components.ItemDetails
import com.alberto.android_rick_morty.presentation.viewmodel.CharacterViewModel
import com.alberto.android_rick_morty.util.UiEvent

@Composable
fun CharacterDetailScreen(
    characterId: String?,
    onNavigate: (UiEvent.Navigate) -> Unit
) {
    val viewModel = hiltViewModel<CharacterViewModel>()
    val state by viewModel.state.collectAsState()
    viewModel.showCharacterDetails(characterId)

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
                title = "Personajes",
                navigateTo = { onNavigate(UiEvent.Navigate(Route.CHARACTER)) }
            )
        }

        Box(
            modifier = Modifier
                .padding(
                    top = 80.dp,
                )
                .align(alignment = Alignment.TopCenter)
        ) {
            AsyncImage(
                model = state.characterSelected?.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(170.dp)
                    .height(170.dp),
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 250.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        horizontal = 20.dp
                    )
                    .fillMaxWidth()
            ) {
                CharacterItems(
                    items = listOf(
                        "nombre: ${state.characterSelected?.name}",
                        "estado: ${state.characterSelected?.status}",
                        "especie: ${state.characterSelected?.species}",
                        "genero: ${state.characterSelected?.gender}",
                        "origen: ${state.characterSelected?.origin?.name}"
                    )
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 470.dp)
        ) {
            ItemDetails(
                title = "EPISODIOS",
                items = state.characterSelected?.episodesAppears
            )
        }
    }
}

@Preview
@Composable
fun CharacterDetailScreenPreview() {
    CharacterDetailScreen(
        "1",
        { }
    )
}