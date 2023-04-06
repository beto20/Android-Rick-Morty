package com.alberto.android_rick_morty.dataexternal.repository

import com.alberto.android_rick_morty.dataexternal.service.EpisodeService
import com.alberto.android_rick_morty.domain.model.EpisodeDomain
import javax.inject.Inject

class EpisodeRepository @Inject constructor(
    private val episodeService: EpisodeService
) {

    suspend fun getAllEpisodes(): List<EpisodeDomain?> {
        return episodeService.getAllEpisodes()
    }
}