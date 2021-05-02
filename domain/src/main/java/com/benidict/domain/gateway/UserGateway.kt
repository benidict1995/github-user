package com.benidict.domain.gateway

import com.benidict.domain.model.User

interface UserGateway {
    suspend fun getUserList(search: String?): List<User>?
}