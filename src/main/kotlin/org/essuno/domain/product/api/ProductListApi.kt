package org.essuno.domain.product.api

import org.essuno.domain.product.dto.ProductItem
import org.essuno.domain.product.dto.ProductListView
import org.essuno.domain.product.service.ProductListService
import org.essuno.global.response.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api")
@RestController
class ProductListApi(
    private val productListService: ProductListService
) {
    @GetMapping("/products")
    fun getProducts(@RequestParam("page") page: Int): ApiResponse<ProductListView>{
        return ApiResponse.success(productListService.getProducts(page))
    }
}