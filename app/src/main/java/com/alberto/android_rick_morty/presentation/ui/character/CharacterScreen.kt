package com.alberto.android_rick_morty.presentation.ui.character

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alberto.android_rick_morty.R
import com.alberto.android_rick_morty.presentation.navigation.Route
import com.alberto.android_rick_morty.presentation.ui.components.Grid
import com.alberto.android_rick_morty.presentation.ui.components.Header
import com.alberto.android_rick_morty.presentation.ui.theme.Background
import com.alberto.android_rick_morty.presentation.viewmodel.CharacterViewModel
import com.alberto.android_rick_morty.util.UiEvent

@Composable
fun CharacterScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    navController: NavController,
) {
    val viewModel = hiltViewModel<CharacterViewModel>()
    val state by viewModel.state.collectAsState()

    Box(
        modifier = Modifier
            .background(color = Background)
            .fillMaxSize()
            .padding(3.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
        ) {
            Header(
                title = stringResource(id = R.string.character),
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
                items = state.characters,
                navController = navController,
                route = Route.CHARACTER_DETAIL
            )
        }
    }
}

@Preview
@Composable
fun EpisodeScreenPreview() {
//    CharacterScreen(
//        onNavigate = {},
//    )
}