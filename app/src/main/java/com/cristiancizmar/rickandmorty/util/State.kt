package com.cristiancizmar.rickandmorty.util

sealed class State<out T> {

    data object Loading : State<Nothing>()

    data class Success<T>(val data: T) : State<T>()

    data class Error(val throwable: Throwable) : State<Nothing>()
}