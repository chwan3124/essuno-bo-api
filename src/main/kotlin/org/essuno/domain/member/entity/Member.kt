package org.essuno.domain.member.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "member")
class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(name="name", nullable = false, length = 100)
    var name: String = ""

    @Column(name="created_at", nullable = false, length = 100)
    var createdAt: Date? = null
}