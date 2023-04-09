package com.alberto.android_rick_morty.dataexternal.mapper

import com.alberto.GetAllCharactersQuery
import com.alberto.GetCharacterDetailsQuery
import com.alberto.android_rick_morty.domain.model.CharacterDomain
import com.alberto.android_rick_morty.domain.model.EpisodeDomain
import com.alberto.android_rick_morty.domain.model.OriginDomain

fun GetAllCharactersQuery.Result.toCharacterDomain(): CharacterDomain {
    return CharacterDomain(
        id = id,
        name = name,
        status = status,
        species = species,
        gender = gender,
        origin = OriginDomain(origin?.name),
        image = image,
        futureUse1 = image,
        episodesAppears = null
    )
}

fun GetCharacterDetailsQuery.Character.toCharacterDomain(): CharacterDomain {
    return CharacterDomain(
        id = id,
        name = name,
        status = status,
        species = species,
        gender = gender,
        origin = OriginDomain(origin?.name),
        image = image,
        futureUse1 = image,
        episodesAppears = episode.map { it?.toEpisodeDomain() }
    )
}

fun GetCharacterDetailsQuery.Episode.toEpisodeDomain(): EpisodeDomain {
    return EpisodeDomain(
        id = id,
        name = name,
        futureUse1 = "",
        airDate = "",
        episode = "",
        charactersInEpisode = null
    )
}