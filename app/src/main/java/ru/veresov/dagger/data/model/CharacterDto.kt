package ru.veresov.dagger.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.veresov.dagger.domain.model.CharacterDmn

@Serializable
class CharacterDto(
    @SerialName(value = "created") val created: String,
    @SerialName(value = "episode") val episode: List<String>,
    @SerialName(value = "gender") val gender: String,
    @SerialName(value = "id") val id: Int,
    @SerialName(value = "image") val image: String,
    @SerialName(value = "location") val location: LocationDto,
    @SerialName(value = "name") val name: String,
    @SerialName(value = "origin") val origin: OriginDto,
    @SerialName(value = "species") val species: String,
    @SerialName(value = "status") val status: String,
    @SerialName(value = "type") val type: String,
    @SerialName(value = "url") val url: String
) {
    fun toDomainObject() = CharacterDmn(
        id,
        name,
        species,
        status,
        type,
        gender,
        origin.toDomainObject(),
        location.toDomainObject(),
        image,
        episode,
        url,
        created
    )
}