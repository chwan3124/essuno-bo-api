package org.essuno.domain.member.api

import org.essuno.domain.member.dto.MemberItem
import org.essuno.domain.member.service.MemberDetailService
import org.essuno.global.response.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api")
@RestController
class MemberDetailApi(
    private val memberDetailService: MemberDetailService
) {

    @GetMapping("/member/{id}")
    fun getMember(@PathVariable id: Long): ApiResponse<MemberItem>{
        return ApiResponse.success(memberDetailService.getMember(id))
    }
}