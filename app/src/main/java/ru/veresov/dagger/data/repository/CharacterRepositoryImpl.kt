package ru.veresov.dagger.data.repository

import io.reactivex.rxjava3.core.Single
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

    override fun loadCharacterById(): Single<LoadCharacterResult> {
        val characterId = CharacterId(1)

        return executeRequest { api.loadCharacters(characterId) }
            .map { response ->
                when (response) {
                    is ResponseResult.Error -> {
                        LoadCharacterResult.Error(
                            response.message,
                            response.code
                        )
                    }

                    is ResponseResult.Success -> {
                        val data = response.data.toDomainObject()
                        LoadCharacterResult.Success(data)
                    }
                }
            }
    }
}