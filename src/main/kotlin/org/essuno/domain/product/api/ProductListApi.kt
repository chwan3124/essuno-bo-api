package org.essuno.domain.product.api

import org.essuno.domain.product.dto.ProductResponse
import org.essuno.domain.product.service.ProductListService
import org.essuno.global.response.ApiResponse
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api")
@RestController
class ProductListApi(
    private val productListService: ProductListService
) {
    @RequestMapping("/products")
    fun getProducts(): ApiResponse<List<ProductResponse>>{
        return ApiResponse.success(productListService.getProducts())
    }
}