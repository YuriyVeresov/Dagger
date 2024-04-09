package ru.veresov.dagger.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
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
    private val disposeBag = CompositeDisposable()

    fun load() {
        val response = repository.loadCharacterById()
        val disposable = response.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { loadResult ->
                val state = loadResult.map(catalogMapper)
                _internalCharacterData.postValue(state)
            }
        disposeBag.add(disposable)
    }

    override fun onCleared() {
        disposeBag.clear()
        super.onCleared()
    }
}