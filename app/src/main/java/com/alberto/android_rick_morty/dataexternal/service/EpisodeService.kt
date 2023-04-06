package com.alberto.android_rick_morty.dataexternal.service

import com.alberto.android_rick_morty.domain.model.EpisodeDomain

interface EpisodeService {
    suspend fun getAllEpisodes(): List<EpisodeDomain?>
}