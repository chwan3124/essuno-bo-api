package org.essuno.domain.product.dto

data class ProductUpdateRequest(
    val name: String,
    val category: String,
    val price: Int,
    val stock: Int
)
