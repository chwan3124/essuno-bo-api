package org.essuno.domain.product.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.Date

@Entity
@Table(name = "product")
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(name="name", nullable = false, length = 100)
    var name: String = ""

    @Column(name="category", nullable = false, length = 100)
    var category: String = ""

    @Column(name="price", nullable = false, length = 100)
    var price: Int = 0

    @Column(name="stock", nullable = false, length = 100)
    var stock: Int = 0

    @Column(name="status", nullable = false, length = 100)
    var status: String = ""

    @Column(name="createdAt", nullable = false, length = 100)
    var createdAt: Date? = null
}