package org.essuno.global.auth.api

import jakarta.servlet.http.HttpServletResponse
import org.essuno.global.auth.dto.LoginRequest
import org.essuno.global.auth.dto.LoginResponse
import org.essuno.global.auth.service.LoginService
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
class LoginApi(
    private val loginService: LoginService
) {

    @PostMapping("/login")
    fun login(
        @RequestBody req: LoginRequest,
        response: HttpServletResponse
    ): ApiResponse<Unit>{
        val res = loginService.login(req)
        val accessTokenCookie = ResponseCookie.from(
            "accessToken",
            res.accessToken
        )
            .httpOnly(true)
            .secure(false) // localhost 개발환경
            .path("/")
            .maxAge(Duration.ofMinutes(30))
            .sameSite("Lax")
            .build()

        val refreshTokenCookie = ResponseCookie.from(
            "refreshToken",
            res.refreshToken
        )
            .httpOnly(true)
            .secure(false)
            .path("/")
            .maxAge(Duration.ofDays(14))
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