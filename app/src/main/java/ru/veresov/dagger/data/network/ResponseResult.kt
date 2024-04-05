package ru.veresov.dagger.data.network

sealed class ResponseResult<out T> {
    data class Success<out T>(val data: T) : ResponseResult<T>()
    data class Error(val message: String, val code: Int) : ResponseResult<Nothing>()
}