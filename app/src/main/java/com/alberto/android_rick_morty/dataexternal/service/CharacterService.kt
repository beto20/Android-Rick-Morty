package com.alberto.android_rick_morty.dataexternal.service

import com.alberto.android_rick_morty.domain.model.CharacterDomain

interface CharacterService {
    suspend fun getAllCharacters(): List<CharacterDomain?>
    suspend fun getCharacterDetails(id: String): CharacterDomain?
}