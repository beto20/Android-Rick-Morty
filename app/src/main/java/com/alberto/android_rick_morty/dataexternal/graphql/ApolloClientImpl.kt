package com.alberto.android_rick_morty.dataexternal.graphql

import com.alberto.GetAllCharactersQuery
import com.alberto.GetAllEpisodesQuery
import com.alberto.GetAllLocationsQuery
import com.alberto.android_rick_morty.dataexternal.mapper.toCharacterDomain
import com.alberto.android_rick_morty.dataexternal.mapper.toEpisodeDomain
import com.alberto.android_rick_morty.dataexternal.mapper.toLocationDomain
import com.alberto.android_rick_morty.domain.model.CharacterDomain
import com.alberto.android_rick_morty.domain.model.EpisodeDomain
import com.alberto.android_rick_morty.domain.model.LocationDomain
import com.apollographql.apollo3.ApolloClient

class ApolloClientImpl(
    private val apolloClient: ApolloClient
): GraphqlService {

    override suspend fun getAllEpisodes(): List<EpisodeDomain?> {
        return apolloClient
            .query(GetAllEpisodesQuery())
            .execute()
            .data
            ?.episodes
            ?.results
            ?.map { it?.toEpisodeDomain() }
            ?: emptyList()
    }

    override suspend fun getAllLocations(): List<LocationDomain?> {
        return apolloClient
            .query(GetAllLocationsQuery())
            .execute()
            .data
            ?.locations
            ?.results
            ?.map { it?.toLocationDomain() }
            ?: emptyList()
    }

    override suspend fun getAllCharacters(): List<CharacterDomain?> {
        return apolloClient
            .query(GetAllCharactersQuery())
            .execute()
            .data
            ?.characters
            ?.results
            ?.map { it?.toCharacterDomain() }
            ?: emptyList()
    }
}