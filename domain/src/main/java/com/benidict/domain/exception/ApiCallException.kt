package com.benidict.domain.exception

import com.benidict.domain.exception.response.ErrorResponse
import java.net.UnknownHostException

@Throws(ServiceException::class)
inline fun <T> apiCall(call: () -> T) = try{
    call()
} catch (e: Exception){
    throw ServiceException(
        when (e){
            is UnknownHostException -> {
                ErrorResponse(
                    message = "No internet connection!",
                    exception = e.cause
                )
            }
            else -> {
                ErrorResponse(
                    message = e.message,
                    exception = e.cause
                )
            }
        }
    )
}