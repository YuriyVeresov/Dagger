package ru.veresov.dagger

import android.app.Application
import ru.veresov.dagger.di.AppComponent
import ru.veresov.dagger.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .create()
    }
}