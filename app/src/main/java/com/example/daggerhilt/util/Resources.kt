package com.example.daggerhilt.util

sealed class Resources<T>(
    val data: T? = null,
    val error: Throwable? = null
) {
    class Sucess<T>(data: T) : Resources<T>()
    class Loading<T>(data: T? = null) : Resources<T>()
    class Error<T>(throwable: Throwable, data: T? = null) : Resources<T>()
}