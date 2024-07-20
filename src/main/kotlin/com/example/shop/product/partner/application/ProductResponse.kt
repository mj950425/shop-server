package com.example.shop.product.partner.application

import java.math.BigDecimal

data class ProductResponse(
    val id: Long,
    val categoryCode: String,
    val salePrice: BigDecimal,
)
