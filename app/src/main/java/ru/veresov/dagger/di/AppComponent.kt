package ru.veresov.dagger.di

import dagger.Component
import ru.veresov.dagger.presentation.MainActivity

@Component(
    modules = [
        DataModule::class,
        DomainModule::class,
        PresentationModule::class
    ]
)
interface AppComponent {
    fun inject(activity: MainActivity)
}