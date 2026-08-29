package org.essuno.global.auth.dto

data class LoginRequest(
    val loginId: String,
    val password: String
)