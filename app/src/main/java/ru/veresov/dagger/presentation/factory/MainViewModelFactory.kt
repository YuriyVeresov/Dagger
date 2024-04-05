package ru.veresov.dagger.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import ru.veresov.dagger.domain.model.LoadCharacterResult
import ru.veresov.dagger.domain.repository.CharacterRepository
import ru.veresov.dagger.presentation.MainActivityViewModel
import ru.veresov.dagger.presentation.state.MainScreenState
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val repository: CharacterRepository,
    private val mapper: LoadCharacterResult.CharacterMapper<MainScreenState>
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
    ): T {
        return MainActivityViewModel(
            repository = repository,
            catalogMapper = mapper
        ) as T
    }
}