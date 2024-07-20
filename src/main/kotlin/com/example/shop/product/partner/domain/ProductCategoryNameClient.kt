package com.example.shop.product.partner.domain

interface ProductCategoryNameClient {
    fun getCategoryCode(categoryId: Long): String
}
