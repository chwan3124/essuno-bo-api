package org.essuno.global.auth.jwt

import jakarta.servlet.FilterChain
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthenticationFilter(
    private val jwtTokenProvider: JwtTokenProvider
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {

        // CORS Preflight 요청은 JWT 검증하지 않음
        if (request.method == "OPTIONS") {
            filterChain.doFilter(request, response)
            return
        }

        val token = resolveToken(request)

        if (
            token != null &&
            jwtTokenProvider.validateToken(token)
        ) {
            val authentication =
                jwtTokenProvider.getAuthentication(token)

            SecurityContextHolder
                .getContext()
                .authentication = authentication
        }

        filterChain.doFilter(request, response)
    }

    /**
     * Cookie에서 accessToken 추출
     *
     * Cookie: accessToken={JWT}
     */
    private fun resolveToken(
        request: HttpServletRequest
    ): String? {

        val cookies = request.cookies ?: return null

        return cookies
            .firstOrNull { it.name == "accessToken" }
            ?.value
    }
}