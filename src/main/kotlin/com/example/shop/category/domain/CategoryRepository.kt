package com.example.shop.category.domain

interface CategoryRepository {
    fun findAll(): List<Category>

    fun save(category: Category): Category

    fun findById(categoryId: Long): Category?

    fun existsByCode_Code(code: String): Boolean
}
