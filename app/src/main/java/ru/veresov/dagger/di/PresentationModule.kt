package ru.veresov.dagger.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.veresov.dagger.presentation.MainActivityViewModel
import ru.veresov.dagger.presentation.util.ViewModelKey

@Module
interface PresentationModule {

    @Binds
    @[IntoMap ViewModelKey(MainActivityViewModel::class)]
    fun provideMainViewModel(
        mainViewModel: MainActivityViewModel
    ): ViewModel
}