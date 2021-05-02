package com.benidict.core.state

sealed class UIState<out T>{
    object Loading: UIState<Nothing>()
    data class Success<out T>(val data: T): UIState<T>()
    data class Error<out T>(val error: String?= null): UIState<T>()
}