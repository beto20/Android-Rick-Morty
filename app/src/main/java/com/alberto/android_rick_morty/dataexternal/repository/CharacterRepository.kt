package com.alberto.android_rick_morty.dataexternal.repository

import com.alberto.android_rick_morty.dataexternal.service.CharacterService
import com.alberto.android_rick_morty.domain.model.CharacterDomain
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val characterService: CharacterService
) {

    suspend fun getAllCharacters(): List<CharacterDomain?> {
        return characterService.getAllCharacters()
    }

}