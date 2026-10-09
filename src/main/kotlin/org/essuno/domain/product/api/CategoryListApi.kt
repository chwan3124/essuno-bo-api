package org.essuno.domain.product.api

import org.essuno.domain.product.dto.CategoryItem
import org.essuno.domain.product.service.CategoryListService
import org.essuno.global.response.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class CategoryListApi(
    private val categoryListService: CategoryListService
) {

    @GetMapping("/categories")
    fun getCategories(@RequestParam("parentId") parentId: Long?): ApiResponse<List<CategoryItem>>{
        return ApiResponse.success(categoryListService.getCategories(parentId))
    }
}