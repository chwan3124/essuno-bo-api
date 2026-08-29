package org.essuno.domain.user.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(name="login_id", nullable = false, length = 100)
    var loginId: String = ""

    @Column(name="password", nullable = false, length = 100)
    var password: String = ""

    @Column(name="name", nullable = false, length = 100)
    var name: String = ""
}