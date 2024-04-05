package ru.veresov.dagger.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import ru.veresov.dagger.presentation.factory.MainViewModelFactory

@Module
interface PresentationModule {

    @Binds
    fun provideViewModelFactory(
        factory: MainViewModelFactory
    ): ViewModelProvider.Factory
}