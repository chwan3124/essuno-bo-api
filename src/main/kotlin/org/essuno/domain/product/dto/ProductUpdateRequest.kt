package org.essuno.domain.product.dto

data class ProductUpdateRequest(
    val name: String,
    val category: Int,
    val price: Int,
    val stock: Int
)
