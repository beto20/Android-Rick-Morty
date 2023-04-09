package com.alberto.android_rick_morty.dataexternal.mapper

import com.alberto.GetAllEpisodesQuery
import com.alberto.GetEpisodeDetailsQuery
import com.alberto.android_rick_morty.domain.model.EpisodeDomain

fun GetAllEpisodesQuery.Result.toEpisodeDomain(): EpisodeDomain {
    return EpisodeDomain(
        id = id,
        name = name,
        airDate = air_date,
        episode = episode,
        futureUse1 = ""
    )
}

fun GetEpisodeDetailsQuery.Episode.toEpisodeDomain(): EpisodeDomain {
    return EpisodeDomain(
        id = id,
        name = name,
        airDate = air_date,
        episode = episode,
        futureUse1 = ""
    )
}