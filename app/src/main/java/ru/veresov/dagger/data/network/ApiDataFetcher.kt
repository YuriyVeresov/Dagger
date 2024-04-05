package ru.veresov.dagger.data.network

import retrofit2.Response

internal interface ApiDataFetcher {
    suspend fun <T> executeRequest(request: suspend () -> Response<T>): ResponseResult<T>
}
