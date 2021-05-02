package com.benidict.domain.model

data class User(
    val login: String?= null,
    val id: String?= null,
    val avatarUrl: String?= null,
    val url: String?= null,
    val htmlUrl: String?= null,
    val followersUrl: String?= null,
    val score: String?= null
)