package ru.veresov.dagger.domain.repository

import io.reactivex.rxjava3.core.Single
import ru.veresov.dagger.domain.model.LoadCharacterResult

interface CharacterRepository {
    fun loadCharacterById(): Single<LoadCharacterResult>
}