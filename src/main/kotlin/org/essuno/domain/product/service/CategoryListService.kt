package org.essuno.domain.product.service

import org.essuno.domain.product.dto.CategoryItem
import org.essuno.domain.product.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryListService(
    private val categoryRepository : CategoryRepository
) {
    fun getCategories(parentId: Long?): List<CategoryItem>{
        val categories = categoryRepository.findAllByParentId(parentId)

        return categories.map { category ->
            CategoryItem(
                id= category.id,
                name = category.name,
                type = category.type,
            )
        }
    }
}