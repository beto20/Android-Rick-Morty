package com.alberto.android_rick_morty.dataexternal.mapper

import com.alberto.GetAllCharactersQuery
import com.alberto.android_rick_morty.domain.model.CharacterDomain
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
    )
}