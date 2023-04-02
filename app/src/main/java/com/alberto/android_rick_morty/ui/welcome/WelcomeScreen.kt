package com.alberto.android_rick_morty.ui.welcome

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alberto.android_rick_morty.navigation.Route
import com.alberto.android_rick_morty.ui.CommonDataClass
import com.alberto.android_rick_morty.ui.components.Header
import com.alberto.android_rick_morty.ui.welcome.components.CustomRow
import com.alberto.android_rick_morty.util.UiEvent

@Composable
fun WelcomeScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(3.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
        ) {
            Header(
                title = "Rick & Morty",
                navigateTo = { onNavigate(UiEvent.Navigate(Route.WELCOME)) }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp),
        ) {

            Column(
                modifier = Modifier
                    .padding(vertical = 4.dp)
            ) {

                CustomRow(
                    { onNavigate(UiEvent.Navigate(Route.EPISODE)) },
                    title = "Episodios",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"
                )

                CustomRow(
                    { onNavigate(UiEvent.Navigate(Route.LOCATION)) },
                    title = "Locaciones",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"
                )

                CustomRow(
                    { onNavigate(UiEvent.Navigate(Route.CHARACTER)) },
                    title = "Personajes",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam"
                )
            }
        }
    }
}

@Preview
@Composable
fun EpisodeScreenPreview() {

    val list = mutableListOf(
        CommonDataClass(
            name = "Episodios",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        ),
        CommonDataClass(
            name = "Locaciones",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        ),
        CommonDataClass(
            name = "Personajes",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        ),
    )

    WelcomeScreen(
        onNavigate = {}
    )
}