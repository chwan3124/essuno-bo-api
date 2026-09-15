package org.essuno.domain.product.service

import org.essuno.domain.product.dto.ProductResponse
import org.essuno.domain.product.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductListService(
    private val productRepository: ProductRepository
) {

    fun getProducts(): List<ProductResponse> {
        val list = productRepository.findAll()

        return list.map { product ->
            ProductResponse(
                id = product.id,
                name = product.name,
                category = product.category.name,
                price = product.price,
                stock = product.stock,
                status =product.status,
                createdAt = product.createdAt,
            )
        }
    }
}