package com.example.shop.product.partner.ui

import java.math.BigDecimal

data class RegisterProductRequest(
    val partnerId: Long,
    val categoryId: Long,
    val salePrice: BigDecimal,
)
