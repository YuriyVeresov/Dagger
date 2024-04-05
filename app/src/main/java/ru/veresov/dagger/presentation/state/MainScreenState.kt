package ru.veresov.dagger.presentation.state

import ru.veresov.dagger.presentation.model.CharacterUi

sealed interface MainScreenState {
    data object Loading : MainScreenState
    data class Success(val character: CharacterUi) : MainScreenState
    data class Error(val errorMessage: String, val errorCode: Int) : MainScreenState
}