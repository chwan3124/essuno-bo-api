package org.essuno

import org.junit.jupiter.api.Test
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class PasswordEncryptTest {

    private val passwordEncoder = BCryptPasswordEncoder()

    @Test
    fun encrypt(){
        val f = passwordEncoder.encode("test")
    }
}