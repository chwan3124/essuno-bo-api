package org.essuno.global.auth.service

import org.essuno.global.auth.dto.LoginRequest
import org.essuno.global.auth.dto.LoginResponse
import org.essuno.global.auth.jwt.JwtTokenProvider
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service

@Service
class LoginService (
    private val authenticationManager: AuthenticationManager,
    private val jwtTokenProvider: JwtTokenProvider
){

    fun login(request: LoginRequest): LoginResponse {

        val authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                request.loginId,
                request.password
            )
        )

        val accessToken =
            jwtTokenProvider.createAccessToken(authentication)

        val refreshToken =
            jwtTokenProvider.createRefreshToken(authentication)

        return LoginResponse(
            accessToken = accessToken,
            refreshToken = refreshToken
        )
    }
}