package com.alberto.android_rick_morty.domain.usecases

import com.alberto.android_rick_morty.dataexternal.repository.CharacterRepository
import com.alberto.android_rick_morty.domain.model.CharacterDomain
import javax.inject.Inject

class GetCharacterDetails @Inject constructor(private val characterRepository: CharacterRepository) {

    suspend operator fun invoke(id: String): CharacterDomain? {
        return characterRepository.getCharacterDetails(id)
    }
}