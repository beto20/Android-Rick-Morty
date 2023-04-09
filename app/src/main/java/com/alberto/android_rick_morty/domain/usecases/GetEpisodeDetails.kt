package com.alberto.android_rick_morty.domain.usecases

import com.alberto.android_rick_morty.dataexternal.repository.EpisodeRepository
import com.alberto.android_rick_morty.domain.model.EpisodeDomain
import com.alberto.android_rick_morty.domain.model.LocationDomain
import javax.inject.Inject

class GetEpisodeDetails @Inject constructor(private val episodeRepository: EpisodeRepository) {

    suspend operator fun invoke(id: String): EpisodeDomain? {
        return episodeRepository.getEpisodeDetails(id)
    }
}