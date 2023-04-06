package com.alberto.android_rick_morty.dataexternal.graphql

import com.alberto.GetAllEpisodesQuery
import com.alberto.android_rick_morty.dataexternal.mapper.toEpisodeDomain
import com.alberto.android_rick_morty.domain.model.EpisodeDomain
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
}