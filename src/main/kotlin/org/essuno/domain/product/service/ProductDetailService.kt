package org.essuno.domain.product.service

import org.essuno.domain.product.dto.ProductItem
import org.essuno.domain.product.dto.ProductOptionItem
import org.essuno.domain.product.repository.CategoryRepository
import org.essuno.domain.product.repository.ProductOptionRepository
import org.essuno.domain.product.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductDetailService(
    private val productRepository: ProductRepository,
    private val categoryRepository: CategoryRepository,
    private val productOptionRepository: ProductOptionRepository
) {

    fun getProduct(id: Long): ProductItem {
        val product = productRepository.findById(id).orElseThrow{ RuntimeException("Product not found") }
        val parentCategory = categoryRepository.findById(product.category.id!!).orElseThrow{ RuntimeException("Parent Cateogry not found") }
        val productOptions = productOptionRepository.findAllByProductId(product.id!!)

        val options = productOptions.map { option ->
            ProductOptionItem(
                id = option.id,
                name = option.name,
                stock = option.stock,
                size = option.size,
                price = option.price,
            )
        }

        return ProductItem(
                id = product.id,
                name = product.name,
                categoryId = product.category.id,
                parentCategoryId = parentCategory.parentId,
                price = product.price,
                stock = product.stock,
                status =product.status,
                options = options,
                createdAt = product.createdAt,
            )
    }
}