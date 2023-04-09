package com.alberto.android_rick_morty.dataexternal.service.impl

import com.alberto.android_rick_morty.dataexternal.graphql.GraphqlService
import com.alberto.android_rick_morty.dataexternal.service.CharacterService
import com.alberto.android_rick_morty.domain.model.CharacterDomain
import javax.inject.Inject

class CharacterServiceImpl @Inject constructor(
    private val graphqlService: GraphqlService
): CharacterService {

    override suspend fun getAllCharacters(): List<CharacterDomain?> {
        return graphqlService.getAllCharacters()
    }

    override suspend fun getCharacterDetails(id: String): CharacterDomain? {
        return graphqlService.getCharacterDetails(id)
    }
}