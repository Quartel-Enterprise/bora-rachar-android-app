package com.quare.blitzsplit.user.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val id: String?,
    val profilePictureUrl: String?,
    val name: String?
)
