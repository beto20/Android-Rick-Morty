package com.alberto.android_rick_morty.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alberto.android_rick_morty.domain.model.EpisodeDomain
import com.alberto.android_rick_morty.domain.usecases.GetAllEpisodes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val getAllEpisodes: GetAllEpisodes
): ViewModel() {

    private val _state = MutableStateFlow(EpisodeState())
    val state = _state.asStateFlow()


    init {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    episodes = getAllEpisodes.invoke()
                )
            }
        }
    }

    data class EpisodeState(
        val episodes: List<EpisodeDomain?> = emptyList()
    )
}