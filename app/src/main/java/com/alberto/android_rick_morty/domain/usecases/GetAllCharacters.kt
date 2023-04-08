package com.alberto.android_rick_morty.domain.usecases

import com.alberto.android_rick_morty.dataexternal.repository.CharacterRepository
import com.alberto.android_rick_morty.domain.model.CharacterDomain
import javax.inject.Inject

class GetAllCharacters @Inject constructor(private val characterRepository: CharacterRepository) {

    suspend operator fun invoke(): List<CharacterDomain?> {
        return characterRepository.getAllCharacters()
    }

}