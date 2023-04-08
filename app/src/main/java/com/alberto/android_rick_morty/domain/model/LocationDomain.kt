package com.alberto.android_rick_morty.domain.model

data class LocationDomain(
    override val id: String?,
    override val name: String?,
    override val futureUse1: String?,
    val type: String?,
    val dimension: String?,
): BaseDomain()
