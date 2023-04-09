package com.alberto.android_rick_morty.dataexternal.graphql

import com.alberto.android_rick_morty.domain.model.CharacterDomain
import com.alberto.android_rick_morty.domain.model.EpisodeDomain
import com.alberto.android_rick_morty.domain.model.LocationDomain

interface GraphqlService {

    suspend fun getAllEpisodes(): List<EpisodeDomain?>
    suspend fun getAllLocations(): List<LocationDomain?>
    suspend fun getAllCharacters(): List<CharacterDomain?>
    suspend fun getCharacterDetails(id: String): CharacterDomain?
    suspend fun getLocationDetails(id: String): LocationDomain?
    suspend fun getEpisodeDetails(id: String): EpisodeDomain?

}