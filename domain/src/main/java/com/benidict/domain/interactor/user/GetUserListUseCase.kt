package com.benidict.domain.interactor.user

import com.benidict.domain.gateway.UserGateway
import com.benidict.domain.model.User

class GetUserListUseCase (private val userGateway: UserGateway){
    suspend fun invoke(search: String?): List<User>?
     = userGateway.getUserList(search)
}