package org.essuno.domain.product.dto

import java.util.Date

data class ProductItem(
    val id: Long? = null,
    var name: String = "",
    var category: String = "",
    var price: Int = 0,
    var stock: Int = 0,
    var status:  String = "",
    var createdAt: Date? = null
)
