package ru.veresov.dagger.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import ru.veresov.dagger.data.model.CharacterDto
import ru.veresov.dagger.data.model.request.CharacterId

interface Api {
    @GET("character/{id}")
    suspend fun loadCharacters(
        @Path("id") id: CharacterId
    ): Response<CharacterDto>
}