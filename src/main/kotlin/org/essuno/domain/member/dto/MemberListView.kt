package org.essuno.domain.member.dto


data class MemberListView(
    val totalCount: Int,
    val totalPage: Int,
    val members: List<MemberItem>
)
