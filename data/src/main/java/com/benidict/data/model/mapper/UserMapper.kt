package com.benidict.data.model.mapper

import com.benidict.data.model.response.UserListResponse
import com.benidict.domain.model.User

object UserMapper {

    fun userMapperResponse(user: UserListResponse): List<User>?
            = user.users?.map { response ->
        User(
                    login =  response.login,
                    id = response.id,
                    avatarUrl = response.avatarUrl,
                    url = response.url,
                    htmlUrl = response.htmlUrl,
                    followersUrl = response.followersUrl,
                    score = response.score
                )
            }?.toList()
}