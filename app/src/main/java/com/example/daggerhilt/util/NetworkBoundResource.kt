package com.example.daggerhilt.util

import kotlinx.coroutines.flow.*

inline fun <ResultType, RequestType> NetworkBoundResource(
    crossinline query: () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline shouldFetch: suspend (ResultType) -> Boolean = { true }
) = flow {

    val data = query().first()

    val flow = if (shouldFetch(data)) {
        emit(Resources.Loading(data))
        try {
            saveFetchResult(fetch())
            query().map { Resources.Sucess(it) }
        } catch (t: Throwable) {
            query().map { Resources.Error(t, it) }
        }
    } else {
        query().map { Resources.Sucess(it) }
    }
    emitAll(flow)


}