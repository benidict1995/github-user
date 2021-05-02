package com.benidict.data.gateway

import com.benidict.data.model.mapper.UserMapper
import com.benidict.data.service.RemoteService
import com.benidict.domain.exception.apiCall
import com.benidict.domain.gateway.UserGateway
import com.benidict.domain.model.User

class UserDataGateway (private var remoteService: RemoteService): UserGateway{

    override suspend fun getUserList(search: String?): List<User>? = apiCall {
       UserMapper.userMapperResponse(remoteService.loadUserList(search?:"a"))
    }

}