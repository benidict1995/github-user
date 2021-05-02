package com.benidict.data.service

import com.benidict.data.model.response.UserListResponse
import retrofit2.http.*

interface RemoteService {
    @Headers("Accept: application/vnd.github.v3+json")
    @GET("/search/users")
    suspend fun loadUserList(
        @Query("q") q: String
    ): UserListResponse
}