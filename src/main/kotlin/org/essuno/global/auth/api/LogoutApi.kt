package org.essuno.global.auth.api

import jakarta.servlet.http.HttpServletResponse
import org.essuno.global.auth.dto.LoginRequest
import org.essuno.global.response.ApiResponse
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseCookie
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Duration

@RequestMapping("/api/auth")
@RestController
class LogoutApi {

    @PostMapping("/logout")
    fun logout(
        response: HttpServletResponse
    ): ApiResponse<Unit>{

        val accessTokenCookie = ResponseCookie.from(
            "accessToken",
            ""
        )
            .httpOnly(true)
            .secure(false)
            .path("/")
            .maxAge(0)
            .sameSite("Lax")
            .build()

        val refreshTokenCookie = ResponseCookie.from(
            "refreshToken",
            ""
        )
            .httpOnly(true)
            .secure(false)
            .path("/")
            .maxAge(0)
            .sameSite("Lax")
            .build()

        response.addHeader(
            HttpHeaders.SET_COOKIE,
            accessTokenCookie.toString()
        )

        response.addHeader(
            HttpHeaders.SET_COOKIE,
            refreshTokenCookie.toString()
        )

        return ApiResponse.success()
    }
}