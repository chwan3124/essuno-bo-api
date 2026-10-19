package org.essuno.domain.product.dto

data class ProductOptionItem(
    val id: Long?,
    val name: String,
    val size: String,
    val price: Int,
    val stock: Int
)
