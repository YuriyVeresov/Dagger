package ru.veresov.dagger.data.repository

import ru.veresov.dagger.data.model.request.CharacterId
import ru.veresov.dagger.data.network.Api
import ru.veresov.dagger.data.network.RemoteDataFetcher
import ru.veresov.dagger.data.network.ResponseResult
import ru.veresov.dagger.domain.model.LoadCharacterResult
import ru.veresov.dagger.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: Api
) : RemoteDataFetcher(), CharacterRepository {

    override suspend fun loadCharacterById(): LoadCharacterResult {
        val characterId = CharacterId(1)

        val loadResult = when (val response = executeRequest { api.loadCharacters(characterId) }) {
            is ResponseResult.Error -> {
                LoadCharacterResult.Error(
                    response.message,
                    response.code
                )
            }

            is ResponseResult.Success -> {
                LoadCharacterResult.Success(response.data.toDomainObject())
            }
        }
        return loadResult
    }
}