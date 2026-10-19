package org.essuno.domain.product.repository

import org.essuno.domain.product.entity.Product
import org.essuno.domain.product.entity.ProductOption
import org.springframework.data.jpa.repository.JpaRepository

interface ProductOptionRepository : JpaRepository<ProductOption, Long> {

    fun findAllByProductId(productId: Long): List<ProductOption>
}