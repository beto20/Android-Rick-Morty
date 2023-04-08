package com.alberto.android_rick_morty.dataexternal.mapper

import com.alberto.GetAllLocationsQuery
import com.alberto.android_rick_morty.domain.model.LocationDomain

fun GetAllLocationsQuery.Result.toLocationDomain(): LocationDomain {
    return LocationDomain(
        id = id,
        name = name,
        type = type,
        dimension = dimension
    )
}