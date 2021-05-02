package com.benidict.data.model.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("login") val login: String?= null,
    @SerializedName("id") val id: String?= null,
    @SerializedName("avatar_url") val avatarUrl: String?= null,
    @SerializedName("url") val url: String?= null,
    @SerializedName("html_url") val htmlUrl: String?= null,
    @SerializedName("followers_url") val followersUrl: String?= null,
    @SerializedName("score") val score: String?= null
)