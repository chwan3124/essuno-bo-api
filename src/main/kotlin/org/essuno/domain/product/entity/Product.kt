package org.essuno.domain.product.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.essuno.domain.product.enum.ProductCategory
import java.util.Date

@Entity
@Table(name = "product")
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(name="name", nullable = false, length = 100)
    var name: String = ""

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    lateinit var category: Category

    @Column(name="price", nullable = false, length = 100)
    var price: Int = 0

    @Column(name="stock", nullable = false, length = 100)
    var stock: Int = 0

    @Column(name="status", nullable = false, length = 100)
    var status: String = ""

    @Column(name="createdAt", nullable = false, length = 100)
    var createdAt: Date? = null
}