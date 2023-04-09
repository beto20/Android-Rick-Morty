package com.alberto.android_rick_morty.dataexternal.mapper

import com.alberto.GetAllEpisodesQuery
import com.alberto.GetEpisodeDetailsQuery
import com.alberto.android_rick_morty.domain.model.CharacterDomain
import com.alberto.android_rick_morty.domain.model.EpisodeDomain

fun GetAllEpisodesQuery.Result.toEpisodeDomain(): EpisodeDomain {
    return EpisodeDomain(
        id = id,
        name = name,
        airDate = air_date,
        episode = episode,
        futureUse1 = "",
        charactersInEpisode = null
    )
}

fun GetEpisodeDetailsQuery.Episode.toEpisodeDomain(): EpisodeDomain {
    return EpisodeDomain(
        id = id,
        name = name,
        airDate = air_date,
        episode = episode,
        futureUse1 = "",
        charactersInEpisode = characters.map { it?.toCharacterDomain() }
    )
}

fun GetEpisodeDetailsQuery.Character.toCharacterDomain(): CharacterDomain {
    return CharacterDomain(
        id = id,
        name = name,
        species = species,
        gender = "",
        status = "",
        futureUse1 = species,
        image = "",
        origin = null,
        episodesAppears = null
    )
}