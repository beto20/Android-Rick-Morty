package com.alberto.android_rick_morty.dataexternal.repository

import com.alberto.android_rick_morty.dataexternal.service.LocationService
import com.alberto.android_rick_morty.domain.model.LocationDomain
import javax.inject.Inject

class LocationRepository @Inject constructor(private val locationService: LocationService) {
    suspend fun getAllLocations(): List<LocationDomain?> {
        return locationService.getAllLocations()
    }

    suspend fun getLocationDetails(id: String): LocationDomain? {
        return locationService.getLocationDetails(id)
    }
}