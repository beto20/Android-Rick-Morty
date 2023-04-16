package com.alberto.android_rick_morty.presentation.ui.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alberto.android_rick_morty.presentation.navigation.Route
import com.alberto.android_rick_morty.presentation.ui.components.Header
import com.alberto.android_rick_morty.presentation.ui.theme.Background
import com.alberto.android_rick_morty.presentation.ui.welcome.components.CustomRow
import com.alberto.android_rick_morty.util.UiEvent

@Composable
fun WelcomeScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
) {
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
                title = stringResource(id = com.alberto.android_rick_morty.R.string.title),
                navigateTo = { onNavigate(UiEvent.Navigate(Route.WELCOME)) }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp),
        ) {

            Column(
                modifier = Modifier
                    .padding(vertical = 4.dp)
            ) {

                CustomRow(
                    { onNavigate(UiEvent.Navigate(Route.EPISODE)) },
                    title = stringResource(id = com.alberto.android_rick_morty.R.string.episode),
                    description = stringResource(id = com.alberto.android_rick_morty.R.string.episode_description)
                )

                CustomRow(
                    { onNavigate(UiEvent.Navigate(Route.LOCATION)) },
                    title = stringResource(id = com.alberto.android_rick_morty.R.string.location),
                    description = stringResource(id = com.alberto.android_rick_morty.R.string.location_description)
                )

                CustomRow(
                    { onNavigate(UiEvent.Navigate(Route.CHARACTER)) },
                    title = stringResource(id = com.alberto.android_rick_morty.R.string.character),
                    description = stringResource(id = com.alberto.android_rick_morty.R.string.character_description)
                )
            }
        }
    }
}

@Preview
@Composable
fun EpisodeScreenPreview() {
    WelcomeScreen(
        onNavigate = {}
    )
}