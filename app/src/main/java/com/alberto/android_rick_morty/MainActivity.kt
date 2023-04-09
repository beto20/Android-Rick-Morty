package com.alberto.android_rick_morty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
                    /*** PRINCIPAL VIEWS ***/
                    composable(Route.EPISODE) {
                        EpisodeScreen(
                            onNavigate = navController::navigate,
                            navController = navController,
                        )
                    }
                    composable(Route.LOCATION) {
                        LocationScreen(
                            onNavigate = navController::navigate,
                            navController = navController,
                        )
                    }
                    composable(Route.CHARACTER) {
                        CharacterScreen(
                            onNavigate = navController::navigate,
                            navController = navController,
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
                        val episodeIdParam = it.arguments?.getString("episodeId")
                        EpisodeDetailScreen(
                            episodeId = episodeIdParam,
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
                        val locationIdParam = it.arguments?.getString("locationId")
                        LocationDetailScreen(
                            locationId = locationIdParam,
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
                        val characterIdParam = it.arguments?.getString("characterId")
                        CharacterDetailScreen(
                            characterId = characterIdParam,
                            onNavigate = navController::navigate,
                        )
                    }
                }
            }
        }
    }
}

