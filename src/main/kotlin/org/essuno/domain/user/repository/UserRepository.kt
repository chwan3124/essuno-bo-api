package org.essuno.domain.user.repository

import org.essuno.domain.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>{
    fun findByLoginId(loginId: String): User?
}