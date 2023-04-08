package com.alberto.android_rick_morty.domain.model


data class EpisodeDomain(
    override val id: String?,
    override val name: String?,
    val airDate: String? = "",
    val episode: String? = "",
): BaseDomain()
