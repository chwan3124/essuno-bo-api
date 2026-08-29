package org.essuno.global.auth.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.util.Date
import javax.crypto.SecretKey

@Component
class JwtTokenProvider(

        @Value("\${jwt.secret}")
        private val secret: String,

        @Value("\${jwt.access-expiration}")
        private val accessExpiration: Long,

        @Value("\${jwt.refresh-expiration}")
        private val refreshExpiration: Long

) {

    private val key: SecretKey
        get() = Keys.hmacShaKeyFor(
                secret.toByteArray(Charsets.UTF_8)
        )

    fun createAccessToken(
            authentication: Authentication
    ): String {
        return createToken(
                authentication,
                accessExpiration
        )
    }

    fun createRefreshToken(
            authentication: Authentication
    ): String {
        return createToken(
                authentication,
                refreshExpiration
        )
    }

    private fun createToken(
            authentication: Authentication,
            expiration: Long
    ): String {

        val now = Date()

        val roles = authentication.authorities
                .map { it.authority }

        return Jwts.builder()
                .setSubject(authentication.name)
                .claim("roles", roles)
                .setIssuedAt(now)
                .setExpiration(
                        Date(now.time + expiration)
                )
                .signWith(
                        key,
                        SignatureAlgorithm.HS256
                )
                .compact()
    }

    fun getAuthentication(
            token: String
    ): Authentication {

        val claims = parseClaims(token)

        val roles = claims["roles"] as? List<*>
                ?: emptyList<Any>()

        val authorities = roles
                .filterIsInstance<String>()
                .map {
                    SimpleGrantedAuthority(it)
                }

        val principal = User(
                claims.subject,
                "",
                authorities
        )

        return UsernamePasswordAuthenticationToken(
                principal,
                null,
                authorities
        )
    }

    fun validateToken(
            token: String
    ): Boolean {

        return try {
            parseClaims(token)
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun parseClaims(
            token: String
    ): Claims {

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .body
    }
}