package org.essuno.domain.member.api

import org.essuno.domain.member.dto.MemberListView
import org.essuno.domain.member.service.MemberListService
import org.essuno.global.response.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api")
@RestController
class MemberListApi(
    private val memberListService: MemberListService
) {

    @GetMapping("/members")
    fun getMembers(@RequestParam("page") page: Int): ApiResponse<MemberListView>{
        return ApiResponse.success(memberListService.getMembers(page));
    }
}