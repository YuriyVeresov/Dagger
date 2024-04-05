package ru.veresov.dagger.domain.repository

import ru.veresov.dagger.domain.model.LoadCharacterResult

interface CharacterRepository {
    suspend fun loadCharacterById(): LoadCharacterResult
}