package com.alberto.android_rick_morty.presentation.ui.character

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
import coil.compose.AsyncImage
import com.alberto.android_rick_morty.presentation.navigation.Route
import com.alberto.android_rick_morty.presentation.ui.character.components.CharacterItems
import com.alberto.android_rick_morty.presentation.ui.components.Header
import com.alberto.android_rick_morty.presentation.ui.components.ItemDetails
import com.alberto.android_rick_morty.presentation.viewmodel.CharacterViewModel
import com.alberto.android_rick_morty.util.UiEvent

@Composable
fun CharacterDetailScreen(
    state: CharacterViewModel.CharacterState,
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
                title = "Personajes",
                navigateTo = { onNavigate(UiEvent.Navigate(Route.CHARACTER)) }
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 100.dp,
                )
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        vertical = 4.dp,
                        horizontal = 20.dp
                    )
                    .fillMaxWidth()
            ) {
                AsyncImage(
                    model = state.characterSelected?.image,
                    contentDescription = null
                )
//                Text(
//                    text = "IMAGEN",
//                    color = Color.Green,
//                    fontSize = 28.sp,
//                    fontFamily = FontFamily.SansSerif,
//                    fontWeight = FontWeight.Medium
//                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 310.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        vertical = 4.dp,
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
                .padding(top = 510.dp)
        ) {
            ItemDetails(
                title = "EPISODIOS",
                items = listOf("https://...", "https://...", "https://...")
            )
        }
    }
}

@Preview
@Composable
fun CharacterDetailScreenPreview() {
//    CharacterDetailScreen({ })
}