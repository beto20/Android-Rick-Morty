package com.alberto.android_rick_morty.domain.model

data class CharacterDomain(
    override val id: String?,
    override val name: String?,
    override val futureUse1: String?,
    val status: String? = "",
    val species: String? = "",
    val gender: String? = "",
    val origin: OriginDomain?,
    val image: String? = "",
    val episodesAppears: List<EpisodeDomain?>?
): BaseDomain()

data class OriginDomain(
    override val name: String? = "",
): BaseDomain()
