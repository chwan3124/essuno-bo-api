package org.essuno.domain.product.dto

data class ProductCreateRequest(
    val name: String,
    val categoryId: Long,
    val price: Int,
    val stock: Int,
    val status: String,
    val options: List<ProductOptionItem>
)
