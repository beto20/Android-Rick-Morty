package com.alberto.android_rick_morty.domain.usecases

import com.alberto.android_rick_morty.dataexternal.repository.LocationRepository
import com.alberto.android_rick_morty.domain.model.LocationDomain
import javax.inject.Inject

class GetAllLocations @Inject constructor(private val locationRepository: LocationRepository) {

    suspend operator fun invoke(): List<LocationDomain?> {
        return locationRepository.getAllLocations()
    }
}