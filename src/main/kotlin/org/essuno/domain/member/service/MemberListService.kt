package org.essuno.domain.member.service

import org.essuno.domain.member.dto.MemberItem
import org.essuno.domain.member.dto.MemberListView
import org.essuno.domain.member.entity.MemberRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class MemberListService(
    private val memberRepository: MemberRepository
) {

    fun getMembers(page: Int): MemberListView {
        val pageable = PageRequest.of(page, 10)
        val memberPage = memberRepository.findAll(pageable)

        val members = memberPage.content.map { member ->
            MemberItem(
                id = member.id,
                name = member.name,
                createdAt = member.createdAt
            )
        }

        return MemberListView(
            totalCount = memberPage.totalElements.toInt(),
            totalPage = memberPage.totalPages,
            members = members
        )
    }
}