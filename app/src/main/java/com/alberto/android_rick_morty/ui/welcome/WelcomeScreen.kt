package com.alberto.android_rick_morty.ui.welcome

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alberto.android_rick_morty.navigation.Route
import com.alberto.android_rick_morty.ui.CommonDataClass
import com.alberto.android_rick_morty.ui.components.GridComponent
import com.alberto.android_rick_morty.ui.components.HeaderComponent
import com.alberto.android_rick_morty.ui.components.LinearListComponent
import com.alberto.android_rick_morty.util.UiEvent

@Composable
fun WelcomeScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    items: List<CommonDataClass>
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
            HeaderComponent(title = "Rick & Morty Diccionario")
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp),
        ) {
            LinearListComponent(
                onClick = { onNavigate(UiEvent.Navigate(Route.LOCATION)) },
                items = items
            )

        }

        Button(
            onClick = { onNavigate(UiEvent.Navigate(Route.LOCATION)) },
            shape = RoundedCornerShape(100.dp)
        ) {
            Text(
                text = "aSas",
                style = MaterialTheme.typography.button,
                color = MaterialTheme.colors.onPrimary,
            )
        }
    }
}

@Preview
@Composable
fun EpisodeScreenPreview() {

    val list = mutableListOf(
        CommonDataClass(name = "Episodios","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."),
        CommonDataClass(name = "Locaciones","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."),
        CommonDataClass(name = "Personajes","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."),
    )

    WelcomeScreen(
        onNavigate = {},
        items = list
    )
}