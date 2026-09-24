package org.essuno.domain.member.dto

import java.util.*

data class MemberItem(
    val id: Long? = null,
    val name: String = "",
    val createdAt: Date? = null
)
