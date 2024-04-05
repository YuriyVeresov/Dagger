package ru.veresov.dagger.domain.model


data class CharacterDmn(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginDmn,
    val location: LocationDmn,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)