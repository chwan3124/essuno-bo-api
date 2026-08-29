package org.essuno.global.auth.dto

data class LoginResponse(
    val accessToken: String,
    val refreshToken: String
)