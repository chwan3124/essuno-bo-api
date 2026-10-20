package org.essuno.domain.product.service

import jakarta.transaction.Transactional
import org.essuno.domain.product.dto.ProductOptionItem
import org.essuno.domain.product.dto.ProductUpdateRequest
import org.essuno.domain.product.entity.Product
import org.essuno.domain.product.entity.ProductOption
import org.essuno.domain.product.enum.ProductCategory
import org.essuno.domain.product.repository.CategoryRepository
import org.essuno.domain.product.repository.ProductOptionRepository
import org.essuno.domain.product.repository.ProductRepository
import org.essuno.global.response.ApiResponse
import org.springframework.stereotype.Service

@Service
class ProductUpdateService(
    private val productRepository: ProductRepository,
    private val categoryRepository: CategoryRepository,
    private val productOptionRepository: ProductOptionRepository
) {

    @Transactional
    fun updateProduct(id: Int, request: ProductUpdateRequest): Unit {
        val category = categoryRepository.findById(request.categoryId.toLong())
            .orElseThrow { IllegalArgumentException("존재하지 않는 카테고리입니다.") }

        val product = productRepository.findById(id.toLong()).orElseThrow { RuntimeException("Product not found") }

        product.name = request.name
        product.category = category
        product.price = request.price
        product.stock = request.stock
        product.status = request.status

        productRepository.save(product)

        if(request.options.isNotEmpty()) {
            request.options.forEach { option ->
                if(option.id == null){
                    createOption(product, option)
                    return@forEach
                }
                val optionItem = productOptionRepository.findById(option.id).orElse(null)
                if(optionItem != null) {
                    optionItem.name = option.name
                    optionItem.price = option.price
                    optionItem.stock = option.stock
                    optionItem.size = option.size
                    productOptionRepository.save(optionItem)
                } else {
                    createOption(product, option)
                }

            }
        }
    }

    fun createOption(product: Product, option: ProductOptionItem): Unit {
        val newOption = ProductOption()
        newOption.name = option.name
        newOption.price = option.price
        newOption.stock = option.stock
        newOption.size = option.size
        newOption.product = product
        productOptionRepository.save(newOption)
    }
}