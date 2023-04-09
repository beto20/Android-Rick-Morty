package com.alberto.android_rick_morty.dataexternal.service

import com.alberto.android_rick_morty.domain.model.LocationDomain

interface LocationService {
    suspend fun getAllLocations(): List<LocationDomain?>
    suspend fun getLocationDetails(id: String): LocationDomain?
}