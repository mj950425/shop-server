package com.example.shop.product.customer.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.SQLRestriction
import java.math.BigDecimal

@Entity
@Table(name = "products")
@SQLRestriction("deleted_at is NULL")
class CustomerProduct(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(name = "sale_price", nullable = false)
    val salePrice: BigDecimal,
    @Column(name = "category_code", nullable = false)
    val categoryCode: String,
    @Column(name = "brand_name", nullable = false)
    val brandName: String,
)
