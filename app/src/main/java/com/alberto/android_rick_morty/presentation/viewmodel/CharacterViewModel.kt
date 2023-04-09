package com.alberto.android_rick_morty.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alberto.android_rick_morty.domain.model.CharacterDomain
import com.alberto.android_rick_morty.domain.usecases.GetAllCharacters
import com.alberto.android_rick_morty.domain.usecases.GetCharacterDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getAllCharacters: GetAllCharacters,
    private val getCharacterDetails: GetCharacterDetails
): ViewModel() {

    private val _state = MutableStateFlow(CharacterState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    characters = getAllCharacters.invoke()
                )
            }
        }
    }

    fun showCharacterDetails(id: String) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    characterSelected = getCharacterDetails.invoke(id)
                )
            }
        }
    }

    data class CharacterState(
        val characters: List<CharacterDomain?> = emptyList(),
        val characterSelected: CharacterDomain? = null
    )
}