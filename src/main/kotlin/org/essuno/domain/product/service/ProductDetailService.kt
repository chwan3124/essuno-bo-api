package org.essuno.domain.product.service

import org.essuno.domain.product.dto.ProductItem
import org.essuno.domain.product.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductDetailService(
    private val productRepository: ProductRepository
) {

    fun getProduct(id: Long): ProductItem {
        val product = productRepository.findById(id).orElseThrow{ RuntimeException("Product not found") }

        return ProductItem(
                id = product.id,
                name = product.name,
                category = "",
                price = product.price,
                stock = product.stock,
                status =product.status,
                createdAt = product.createdAt,
            )
    }
}