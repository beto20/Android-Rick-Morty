package com.alberto.android_rick_morty.dataexternal.service.impl

import com.alberto.android_rick_morty.dataexternal.service.EpisodeService
import com.alberto.android_rick_morty.dataexternal.graphql.GraphqlService
import com.alberto.android_rick_morty.domain.model.EpisodeDomain
import javax.inject.Inject

class EpisodeServiceImpl @Inject constructor(
    private val graphqlService: GraphqlService
): EpisodeService {

    override suspend fun getAllEpisodes(): List<EpisodeDomain?> {
        return graphqlService.getAllEpisodes()
    }

}