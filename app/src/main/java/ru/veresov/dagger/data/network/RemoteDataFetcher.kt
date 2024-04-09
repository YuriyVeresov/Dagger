package ru.veresov.dagger.data.network

import io.reactivex.rxjava3.core.Single
import retrofit2.Response

abstract class RemoteDataFetcher : ApiDataFetcher {
    override fun <T> executeRequest(request: () -> Single<Response<T>>): Single<ResponseResult<T>> {
        return request.invoke()
            .map<ResponseResult<T>> { result ->
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
            }
            .onErrorReturn {
                ResponseResult.Error(
                    message = "Check Network Connection",
                    code = 111
                )
            }
    }
}