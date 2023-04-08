package com.alberto.android_rick_morty.domain.usecases

import com.alberto.android_rick_morty.dataexternal.repository.EpisodeRepository
import com.alberto.android_rick_morty.domain.model.EpisodeDomain
import javax.inject.Inject

class GetAllEpisodes @Inject constructor(private val episodeRepository: EpisodeRepository) {

    suspend operator fun invoke(): List<EpisodeDomain?> {
        return episodeRepository.getAllEpisodes()
    }
}