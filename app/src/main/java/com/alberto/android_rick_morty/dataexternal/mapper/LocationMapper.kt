package com.alberto.android_rick_morty.dataexternal.mapper

import com.alberto.GetAllLocationsQuery
import com.alberto.GetLocationDetailsQuery
import com.alberto.android_rick_morty.domain.model.CharacterDomain
import com.alberto.android_rick_morty.domain.model.LocationDomain

fun GetAllLocationsQuery.Result.toLocationDomain(): LocationDomain {
    return LocationDomain(
        id = id,
        name = name,
        type = type,
        dimension = dimension,
        futureUse1 = "",
        residents = null
    )
}

fun GetLocationDetailsQuery.Location.toLocationDomain(): LocationDomain {
    return LocationDomain(
        id = id,
        name = name,
        type = type,
        dimension = dimension,
        futureUse1 = "",
        residents = residents.map { it?.toCharacterDomain() }
    )
}

fun GetLocationDetailsQuery.Resident.toCharacterDomain(): CharacterDomain {
    return CharacterDomain(
        id = id,
        name = name,
        status = "",
        species = species,
        gender = "",
        origin = null,
        image = "",
        futureUse1 = species,
        episodesAppears = null
    )
}