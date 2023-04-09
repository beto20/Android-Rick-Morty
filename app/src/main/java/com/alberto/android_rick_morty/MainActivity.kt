package com.alberto.android_rick_morty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
                            navController = navController,
                            state = state
                        )
                    }
                    composable(Route.LOCATION) {
                        val viewModel = hiltViewModel<LocationViewModel>()
                        val state by viewModel.state.collectAsState()

                        LocationScreen(
                            onNavigate = navController::navigate,
                            navController = navController,
                            state = state
                        )
                    }
                    composable(Route.CHARACTER) {
                        val viewModel = hiltViewModel<CharacterViewModel>()
                        val state by viewModel.state.collectAsState()

                        CharacterScreen(
                            onNavigate = navController::navigate,
                            navController = navController,
                            state = state,
                        )
                    }
                    /*** DETAILS VIEWS ***/
                    composable(
                        route = Route.EPISODE_DETAIL + "/{episodeId}",
                        arguments = listOf(
                            navArgument("episodeId") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val viewModel = hiltViewModel<EpisodeViewModel>()
                        val state by viewModel.state.collectAsState()

                        val episodeId = it.arguments?.getString("episodeId")

                        if (episodeId != null) {
                            viewModel.showEpisodeDetails(episodeId)
                        }

                        EpisodeDetailScreen(
                            state = state,
                            onNavigate = navController::navigate,
                        )
                    }
                    composable(
                        route = Route.LOCATION_DETAIL + "/{locationId}",
                        arguments = listOf(
                            navArgument("locationId") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val viewModel = hiltViewModel<LocationViewModel>()
                        val state by viewModel.state.collectAsState()

                        val locationId = it.arguments?.getString("locationId")

                        if (locationId != null) {
                            viewModel.showLocationDetails(locationId)
                        }

                        LocationDetailScreen(
                            state = state,
                            onNavigate = navController::navigate,
                        )
                    }
                    composable(
                        route = Route.CHARACTER_DETAIL + "/{characterId}",
                        arguments = listOf(
                            navArgument("characterId") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val viewModel = hiltViewModel<CharacterViewModel>()
                        val state by viewModel.state.collectAsState()

                        val characterId = it.arguments?.getString("characterId")

                        if (characterId != null) {
                            viewModel.showCharacterDetails(characterId)
                        }

                        CharacterDetailScreen(
                            state = state,
                            onNavigate = navController::navigate,
                        )
                    }
                }
            }
        }
    }
}

