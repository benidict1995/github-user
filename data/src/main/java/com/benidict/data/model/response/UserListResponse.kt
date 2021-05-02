package com.benidict.data.model.response

import com.google.gson.annotations.SerializedName

data class UserListResponse(
    @SerializedName("total_count") val totalCount: String?= null,
    @SerializedName("incomplete_results") val incompleteResults: String?= null,
    @SerializedName("items") val users:List<UserResponse>?= null
)