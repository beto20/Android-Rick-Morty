package com.alberto.android_rick_morty.dataexternal.service.impl

import com.alberto.android_rick_morty.dataexternal.service.EpisodeService
import com.alberto.android_rick_morty.dataexternal.graphql.GraphqlService
import com.alberto.android_rick_morty.dataexternal.service.LocationService
import com.alberto.android_rick_morty.domain.model.EpisodeDomain
import com.alberto.android_rick_morty.domain.model.LocationDomain
import javax.inject.Inject

class LocationServiceImpl @Inject constructor(
    private val graphqlService: GraphqlService
): LocationService {

    override suspend fun getAllLocations(): List<LocationDomain?> {
        return graphqlService.getAllLocations()
    }

}