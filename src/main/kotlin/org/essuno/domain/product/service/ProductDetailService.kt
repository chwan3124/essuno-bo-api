package org.essuno.domain.product.service

import org.essuno.domain.product.dto.ProductResponse
import org.essuno.domain.product.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductDetailService(
    private val productRepository: ProductRepository
) {

    fun getProduct(id: Long): ProductResponse {
        val product = productRepository.findById(id).orElseThrow{ RuntimeException("Product not found") }

        return ProductResponse(
                id = product.id,
                name = product.name,
                category = product.category,
                price = product.price,
                stock = product.stock,
                status =product.status,
                createdAt = product.createdAt,
            )
    }
}