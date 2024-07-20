package com.example.shop.product.partner.ui

import java.math.BigDecimal

data class UpdateProductRequest(
    val categoryId: Long,
    val salePrice: BigDecimal,
)
