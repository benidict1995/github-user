package com.benidict.domain.exception

import com.benidict.domain.exception.response.ErrorResponse

open class ServiceException(
    errorResponse: ErrorResponse
): RuntimeException(errorResponse.message)