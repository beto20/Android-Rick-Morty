package com.alberto.android_rick_morty.util

sealed class UiEvent {

    data class Navigate(val route: String): UiEvent()
    object NavigateUp: UiEvent()
}
