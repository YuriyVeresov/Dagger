package ru.veresov.dagger.presentation

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.veresov.dagger.databinding.ActivityMainBinding
import ru.veresov.dagger.presentation.factory.ViewModelFactory
import ru.veresov.dagger.presentation.model.CharacterUi
import ru.veresov.dagger.presentation.state.MainScreenState
import ru.veresov.dagger.presentation.util.appComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: MainActivityViewModel
    private var _binding: ActivityMainBinding? = null
    private val vb get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(vb.root)

        applicationContext.appComponent.inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)[MainActivityViewModel::class.java]
        viewModel.load()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.externalCharacterData.observe(this@MainActivity) { state ->
            when (state) {
                is MainScreenState.Error -> {
                    showErrorState(state.errorMessage)
                }

                MainScreenState.Loading -> {
                    showLoadingState()
                }

                is MainScreenState.Success -> {
                    showSuccessState(state.character)
                }
            }
        }
    }

    private fun showErrorState(errorMessage: String) {
        vb.progressBar.visibility = GONE
        vb.tvTextView.text = errorMessage
    }

    private fun showLoadingState() {
        vb.progressBar.visibility = View.VISIBLE
    }

    private fun showSuccessState(character: CharacterUi) {
        vb.progressBar.visibility = GONE
        vb.tvTextView.text = character.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}