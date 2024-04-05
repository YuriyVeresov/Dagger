package ru.veresov.dagger.presentation.util

import android.content.Context
import ru.veresov.dagger.App

val Context.appComponent
    get() = when (this) {
        is App -> appComponent
        else -> (this.applicationContext as App).appComponent
    }