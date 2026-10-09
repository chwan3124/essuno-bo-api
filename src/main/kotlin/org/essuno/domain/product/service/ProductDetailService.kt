package org.essuno.domain.product.service

import org.essuno.domain.product.dto.ProductItem
import org.essuno.domain.product.repository.CategoryRepository
import org.essuno.domain.product.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductDetailService(
    private val productRepository: ProductRepository,
    private val categoryRepository: CategoryRepository
) {

    fun getProduct(id: Long): ProductItem {
        val product = productRepository.findById(id).orElseThrow{ RuntimeException("Product not found") }
        val parentCategory = categoryRepository.findById(product.category.id!!).orElseThrow{ RuntimeException("Parent Cateogry not found") }

        return ProductItem(
                id = product.id,
                name = product.name,
                categoryId = product.category.id,
                parentCategoryId = parentCategory.parentId,
                price = product.price,
                stock = product.stock,
                status =product.status,
                createdAt = product.createdAt,
            )
    }
}