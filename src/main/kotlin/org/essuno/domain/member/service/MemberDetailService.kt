package org.essuno.domain.member.service

import org.essuno.domain.member.dto.MemberItem
import org.essuno.domain.member.entity.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberDetailService (
    private val memberRepository: MemberRepository
){

    fun getMember(id: Long): MemberItem{
        val member = memberRepository.findById(id).orElseThrow{ RuntimeException("Member Not Found") }

        return MemberItem(
            id = member.id,
            name = member.name,
        )
    }
}