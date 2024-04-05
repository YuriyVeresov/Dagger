package ru.veresov.dagger.di

import dagger.Binds
import dagger.Module
import ru.veresov.dagger.domain.model.LoadCharacterResult
import ru.veresov.dagger.presentation.mapper.CharacterUiMapper
import ru.veresov.dagger.presentation.state.MainScreenState

@Module
interface DomainModule {
    @Binds
    fun provideLoadCharacterMapper(
        mapper: CharacterUiMapper
    ): LoadCharacterResult.CharacterMapper<MainScreenState>
}