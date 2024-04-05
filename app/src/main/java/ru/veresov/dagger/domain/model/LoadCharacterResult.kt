package ru.veresov.dagger.domain.model

interface LoadCharacterResult {

    interface CharacterMapper<T : Any> {
        fun mapSuccess(character: CharacterDmn): T
        fun mapError(errorMessage: String, errorCode: Int): T
    }

    fun <T : Any> map(mapper: CharacterMapper<T>): T

    data class Success(private val character:CharacterDmn) : LoadCharacterResult {
        override fun <T : Any> map(mapper: CharacterMapper<T>): T {
            return mapper.mapSuccess(character)
        }
    }

    data class Error(private val errorMessage: String, private val errorCode: Int) :
        LoadCharacterResult {
        override fun <T : Any> map(mapper: CharacterMapper<T>): T {
            return mapper.mapError(errorMessage, errorCode)
        }
    }
}