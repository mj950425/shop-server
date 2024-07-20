package com.example.shop.category.application

data class CategoriesResponse(
    val categories: List<Category>,
) {
    data class Category(
        val id: Long,
        val code: String,
    )
}
