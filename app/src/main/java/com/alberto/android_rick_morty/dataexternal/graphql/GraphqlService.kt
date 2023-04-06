package com.alberto.android_rick_morty.dataexternal.graphql

import com.alberto.android_rick_morty.domain.model.EpisodeDomain

interface GraphqlService {

    suspend fun getAllEpisodes(): List<EpisodeDomain?>

}