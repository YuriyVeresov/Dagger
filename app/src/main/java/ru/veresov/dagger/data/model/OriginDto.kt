package ru.veresov.dagger.data.model

import kotlinx.serialization.Serializable
import ru.veresov.dagger.domain.model.OriginDmn

@Serializable
class OriginDto(
    private val name: String,
    private val url: String
) {
    fun toDomainObject() = OriginDmn(name, url)
}