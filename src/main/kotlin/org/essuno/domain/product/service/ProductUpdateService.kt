package org.essuno.domain.product.service

import jakarta.transaction.Transactional
import org.essuno.domain.product.dto.ProductUpdateRequest
import org.essuno.domain.product.entity.Product
import org.essuno.domain.product.enum.ProductCategory
import org.essuno.domain.product.repository.CategoryRepository
import org.essuno.domain.product.repository.ProductRepository
import org.essuno.global.response.ApiResponse
import org.springframework.stereotype.Service

@Service
class ProductUpdateService(
    private val productRepository: ProductRepository,
    private val categoryRepository: CategoryRepository
) {

    @Transactional
    fun updateProduct(id: Int, request: ProductUpdateRequest): Unit {
        val category = categoryRepository.findById(request.category.toLong())
            .orElseThrow { IllegalArgumentException("존재하지 않는 카테고리입니다.") }

        val product = productRepository.findById(id.toLong()).orElseThrow { RuntimeException("Product not found") }

        product.name = request.name
        product.category = category
        product.price = request.price
        product.stock = request.stock

        productRepository.save(product)
    }
}