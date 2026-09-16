package org.essuno.domain.product.api

import org.essuno.domain.product.dto.ProductUpdateRequest
import org.essuno.domain.product.service.ProductCreateService
import org.essuno.global.response.ApiResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api")
@RestController
class ProductCreateApi(
    private val productCreateService: ProductCreateService
) {

    @PostMapping("/product")
    fun updateProduct(@RequestBody request: ProductUpdateRequest): ApiResponse<Unit> {
        productCreateService.createProduct(request)
        return ApiResponse.success()
    }
}