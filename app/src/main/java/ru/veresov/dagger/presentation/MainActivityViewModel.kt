package ru.veresov.dagger.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.veresov.dagger.domain.model.LoadCharacterResult
import ru.veresov.dagger.domain.repository.CharacterRepository
import ru.veresov.dagger.presentation.state.MainScreenState
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val repository: CharacterRepository,
    private val catalogMapper: LoadCharacterResult.CharacterMapper<MainScreenState>,
) : ViewModel() {

    private val _internalCharacterData = MutableLiveData<MainScreenState>(MainScreenState.Loading)
    val externalCharacterData: LiveData<MainScreenState> get() = _internalCharacterData

    fun load() {
        viewModelScope.launch {
            val result = repository.loadCharacterById()
            val state = result.map(catalogMapper)
            _internalCharacterData.postValue(state)
        }
    }

}