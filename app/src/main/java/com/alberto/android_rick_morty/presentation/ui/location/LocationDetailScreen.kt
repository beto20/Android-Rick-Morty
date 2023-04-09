package com.alberto.android_rick_morty.presentation.ui.location

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alberto.android_rick_morty.presentation.navigation.Route
import com.alberto.android_rick_morty.presentation.ui.components.Header
import com.alberto.android_rick_morty.presentation.ui.components.ItemDetails
import com.alberto.android_rick_morty.presentation.ui.location.components.LocationItems
import com.alberto.android_rick_morty.presentation.viewmodel.LocationViewModel
import com.alberto.android_rick_morty.util.UiEvent

@Composable
fun LocationDetailScreen(
    state: LocationViewModel.LocationState,
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
                title = "Locaciones",
                navigateTo = { onNavigate(UiEvent.Navigate(Route.LOCATION)) }
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
                LocationItems(
                    items = listOf(
                        "nombre: ${state.locationSelected?.name}",
                        "tipo: ${state.locationSelected?.type}",
                        "dimension: ${state.locationSelected?.dimension}"
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
                items = listOf("https://...", "https://...", "https://...")
            )
        }
    }
}

@Preview
@Composable
fun LocationDetailScreenPreview() {
//    LocationDetailScreen({ })
}