package org.essuno.global.auth.service

import org.springframework.security.core.userdetails.User
import org.essuno.domain.user.repository.UserRepository
import org.essuno.global.auth.enum.Role
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class AuthUserDetailsService(
        private val userRepository: UserRepository
) : UserDetailsService{
    override fun loadUserByUsername(loginId: String): UserDetails {
        val user = userRepository.findByLoginId(loginId)?: throw UsernameNotFoundException("user not found")


        return User.builder()
                .username(user.loginId)
                .password(user.password)
                .roles(Role.ADMIN.name)
                .build()
    }


}