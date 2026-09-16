package org.essuno.domain.product.api

import org.essuno.domain.product.dto.ProductUpdateRequest
import org.essuno.domain.product.service.ProductUpdateService
import org.essuno.global.response.ApiResponse
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api")
@RestController
class ProductUpdateApi(
    private val productUpdateService: ProductUpdateService
) {

    @PatchMapping("/product/{id}")
    fun updateProduct(@PathVariable("id") id: Int, @RequestBody request: ProductUpdateRequest): ApiResponse<Unit> {
        productUpdateService.updateProduct(id, request)
        return ApiResponse.success()
    }
}