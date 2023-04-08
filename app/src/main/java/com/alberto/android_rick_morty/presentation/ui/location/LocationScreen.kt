package com.alberto.android_rick_morty.presentation.ui.location

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alberto.android_rick_morty.presentation.navigation.Route
import com.alberto.android_rick_morty.presentation.ui.components.Grid
import com.alberto.android_rick_morty.presentation.ui.components.Header
import com.alberto.android_rick_morty.presentation.viewmodel.LocationViewModel
import com.alberto.android_rick_morty.util.UiEvent

@Composable
fun LocationScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    state: LocationViewModel.LocationState
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(3.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
        ) {
            Header(
                title = "Locaciones",
                navigateTo = { onNavigate(UiEvent.Navigate(Route.WELCOME)) }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp),
        ) {
            Grid(
                context = LocalContext.current,
                items = state.locations,
                navigateTo = { onNavigate(UiEvent.Navigate(Route.LOCATION_DETAIL)) }
            )
        }
    }
}

@Preview
@Composable
fun EpisodeScreenPreview() {

//    LocationScreen(
//        onNavigate = {},
//    )
}