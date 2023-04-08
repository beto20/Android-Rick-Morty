package com.alberto.android_rick_morty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alberto.android_rick_morty.presentation.navigation.Route
import com.alberto.android_rick_morty.presentation.navigation.navigate
import com.alberto.android_rick_morty.presentation.ui.character.CharacterDetailScreen
import com.alberto.android_rick_morty.presentation.ui.character.CharacterScreen
import com.alberto.android_rick_morty.presentation.ui.episode.EpisodeDetailScreen
import com.alberto.android_rick_morty.presentation.ui.episode.EpisodeScreen
import com.alberto.android_rick_morty.presentation.ui.location.LocationDetailScreen
import com.alberto.android_rick_morty.presentation.ui.location.LocationScreen
import com.alberto.android_rick_morty.presentation.ui.theme.AndroidRickMortyTheme
import com.alberto.android_rick_morty.presentation.ui.welcome.WelcomeScreen
import com.alberto.android_rick_morty.presentation.viewmodel.CharacterViewModel
import com.alberto.android_rick_morty.presentation.viewmodel.EpisodeViewModel
import com.alberto.android_rick_morty.presentation.viewmodel.LocationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AndroidRickMortyTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Route.WELCOME
                ) {
                    /*** WELCOME ***/
                    composable(
                        route = Route.WELCOME
                    ) {
                        WelcomeScreen(
                            onNavigate = navController::navigate,
                        )
                    }
                    /*** FIRST VIEWS ***/
                    composable(Route.EPISODE) {
                        val viewModel = hiltViewModel<EpisodeViewModel>()
                        val state by viewModel.state.collectAsState()

                        EpisodeScreen(
                            onNavigate = navController::navigate,
                            state = state
                        )
                    }
                    composable(Route.LOCATION) {
                        val viewModel = hiltViewModel<LocationViewModel>()
                        val state by viewModel.state.collectAsState()

                        LocationScreen(
                            onNavigate = navController::navigate,
                            state = state
                        )
                    }
                    composable(Route.CHARACTER) {
                        val viewModel = hiltViewModel<CharacterViewModel>()
                        val state by viewModel.state.collectAsState()

                        CharacterScreen(
                            onNavigate = navController::navigate,
                            state = state
                        )
                    }
                    /*** DETAILS VIEWS ***/
                    composable(
                        route = Route.EPISODE_DETAIL,
//                        arguments =
                    ) {
                        EpisodeDetailScreen(
                            onNavigate = navController::navigate,
                        )
                    }
                    composable(
                        route = Route.LOCATION_DETAIL,
//                        arguments =
                    ) {
                        LocationDetailScreen(
                            onNavigate = navController::navigate,
                        )
                    }
                    composable(
                        route = Route.CHARACTER_DETAIL,
//                        arguments =
                    ) {
                        CharacterDetailScreen(
                            onNavigate = navController::navigate,
                        )
                    }
                }
            }
        }
    }
}

