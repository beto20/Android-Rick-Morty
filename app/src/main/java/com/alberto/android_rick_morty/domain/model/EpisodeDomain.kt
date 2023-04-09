package com.alberto.android_rick_morty.domain.model


data class EpisodeDomain(
    override val id: String?,
    override val name: String?,
    override val futureUse1: String?,
    val airDate: String? = "",
    val episode: String? = "",
    val charactersInEpisode: List<CharacterDomain?>?
): BaseDomain()
