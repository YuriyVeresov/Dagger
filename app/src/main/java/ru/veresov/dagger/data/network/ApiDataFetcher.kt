package ru.veresov.dagger.data.network

import io.reactivex.rxjava3.core.Single
import retrofit2.Response

internal interface ApiDataFetcher {
    fun <T> executeRequest(request: () -> Single<Response<T>>): Single<ResponseResult<T>>
}
