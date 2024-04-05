package ru.veresov.dagger.data.network

import retrofit2.Response

abstract class RemoteDataFetcher : ApiDataFetcher {
    override suspend fun <T> executeRequest(request: suspend () -> Response<T>): ResponseResult<T> {
        return try {
            val result = request.invoke()
            val response = result.body()

            when {
                result.isSuccessful && response != null -> {
                    ResponseResult.Success(response)
                }

                result.isSuccessful && response == null -> {
                    ResponseResult.Error("empty body", 222)
                }

                else -> {
                    ResponseResult.Error("Network error", 333)
                }
            }

        } catch (e: Exception) {
            ResponseResult.Error(
                message = "Check Network Connection",
                code = 111
            )
        }
    }
}