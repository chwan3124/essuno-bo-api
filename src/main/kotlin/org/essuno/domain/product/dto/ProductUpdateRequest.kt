package org.essuno.domain.product.dto

data class ProductUpdateRequest(
    val name: String,
    val categoryId: Long,
    val price: Int,
    val stock: Int
)
