package com.bookmyshow.core.di.network

sealed class Resource<out T> {
    class Success<out T>(val data: T) : Resource<T>()
    class Error<out T>(val error: String? = null) : Resource<T>()
    class Loading<out T>(val isLoading: Boolean) : Resource<T>()
}