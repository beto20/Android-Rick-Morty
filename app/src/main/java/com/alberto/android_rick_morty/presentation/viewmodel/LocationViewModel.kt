package com.alberto.android_rick_morty.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alberto.android_rick_morty.domain.model.LocationDomain
import com.alberto.android_rick_morty.domain.usecases.GetAllLocations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val getAllLocations: GetAllLocations
): ViewModel() {

    private val _state = MutableStateFlow(LocationState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val response = getAllLocations.invoke()
            _state.update {
                it.copy(locations = response)
            }
        }
    }

    data class LocationState(
        val locations: List<LocationDomain?> = emptyList()
    )
}