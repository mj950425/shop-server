package com.example.shop.product.customer.application

import java.math.BigDecimal

data class CheapestPartnerResponse(
    val brandName: String,
    val totalPrice: BigDecimal,
    val products: List<Product>,
) {
    data class Product(
        val id: Long,
        val categoryCode: String,
        val salePrice: BigDecimal,
    )
}
