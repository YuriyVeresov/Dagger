package ru.veresov.dagger.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import ru.veresov.dagger.data.network.Api
import ru.veresov.dagger.data.repository.CharacterRepositoryImpl
import ru.veresov.dagger.domain.repository.CharacterRepository

@Module(
    includes = [
        NetworkModule::class
    ]
)
interface DataModule {
    @Binds
    fun provideCharacterRepository(
        repository: CharacterRepositoryImpl
    ): CharacterRepository
}


@Module
class NetworkModule {
    @Provides
    fun provideApi(): Api {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()

        return retrofit.create(Api::class.java)
    }
}