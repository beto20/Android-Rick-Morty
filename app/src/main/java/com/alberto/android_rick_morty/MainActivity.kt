package com.alberto.android_rick_morty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alberto.android_rick_morty.navigation.Route
import com.alberto.android_rick_morty.navigation.navigate
import com.alberto.android_rick_morty.ui.CommonDataClass
import com.alberto.android_rick_morty.ui.character.CharacterDetailScreen
import com.alberto.android_rick_morty.ui.character.CharacterScreen
import com.alberto.android_rick_morty.ui.episode.EpisodeDetailScreen
import com.alberto.android_rick_morty.ui.episode.EpisodeScreen
import com.alberto.android_rick_morty.ui.location.LocationDetailScreen
import com.alberto.android_rick_morty.ui.location.LocationScreen
import com.alberto.android_rick_morty.ui.theme.AndroidRickMortyTheme
import com.alberto.android_rick_morty.ui.welcome.WelcomeScreen

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
                    composable(
                        route = Route.WELCOME
                    ) {
                        WelcomeScreen(
                            onNavigate = navController::navigate,
                        )
                    }
                    composable(Route.EPISODE) {
                        val list = mutableListOf(
                            CommonDataClass(
                                name = "mock 1",
                                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                            ),
                            CommonDataClass(
                                name = "mock 2",
                                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                            ),
                            CommonDataClass(
                                name = "mock 3",
                                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                            ),
                            CommonDataClass(
                                name = "mock 4",
                                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                            ),
                            CommonDataClass(
                                name = "mock 5",
                                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                            ),
                        )
                        EpisodeScreen(
                            onNavigate = navController::navigate,
                            episodeList = list
                        )
                    }
                    composable(Route.LOCATION) {
                        val list = mutableListOf(
                            CommonDataClass(
                                name = "mock 1",
                                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                            ),
                            CommonDataClass(
                                name = "mock 2",
                                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                            ),
                            CommonDataClass(
                                name = "mock 3",
                                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                            ),
                            CommonDataClass(
                                name = "mock 4",
                                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                            ),
                            CommonDataClass(
                                name = "mock 5",
                                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                            ),
                        )
                        LocationScreen(
                            onNavigate = navController::navigate,
                            episodeList = list
                        )
                    }
                    composable(Route.CHARACTER) {
                        val list = mutableListOf(
                            CommonDataClass(
                                name = "mock 1",
                                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                            ),
                            CommonDataClass(
                                name = "mock 2",
                                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                            ),
                            CommonDataClass(
                                name = "mock 3",
                                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                            ),
                            CommonDataClass(
                                name = "mock 4",
                                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                            ),
                            CommonDataClass(
                                name = "mock 5",
                                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                            ),
                        )
                        CharacterScreen(
                            onNavigate = navController::navigate,
                            episodeList = list
                        )
                    }

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

