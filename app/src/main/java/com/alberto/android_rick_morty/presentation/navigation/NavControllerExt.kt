package com.alberto.android_rick_morty.presentation.navigation

import androidx.navigation.NavController
import com.alberto.android_rick_morty.util.UiEvent


fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}