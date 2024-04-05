package ru.veresov.dagger.data.model

import kotlinx.serialization.Serializable
import ru.veresov.dagger.domain.model.LocationDmn

@Serializable
class LocationDto(
    private val name: String,
    private val url: String
) {
    fun toDomainObject() = LocationDmn(name, url)
}