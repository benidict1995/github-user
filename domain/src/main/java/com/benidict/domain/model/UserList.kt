package com.benidict.domain.model

import com.google.gson.annotations.SerializedName

data class UserList(
    val totalCount: String?= null,
    val incompleteResults: String?= null,
    val users:List<User>?= null
)