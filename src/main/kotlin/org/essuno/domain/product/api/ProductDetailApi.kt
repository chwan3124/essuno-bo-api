package org.essuno.domain.product.api

import org.essuno.domain.product.dto.ProductItem
import org.essuno.domain.product.service.ProductDetailService
import org.essuno.global.response.ApiResponse
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api")
@RestController
class ProductDetailApi(
    private val productDetailService: ProductDetailService
) {
    @RequestMapping("/product/{id}")
    fun getProduct(@PathVariable("id") id: Long): ApiResponse<ProductItem>{
        return ApiResponse.success(productDetailService.getProduct(id))
    }
}