package org.essuno.domain.product.dto

data class ProductListView(
    val totalCount: Int,
    val totalPage: Int,
    val products: List<ProductItem>
) {

}