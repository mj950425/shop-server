package com.example.shop.category.infra

import com.example.shop.category.domain.Category
import com.example.shop.category.domain.CategoryRepository
import org.springframework.data.jpa.repository.JpaRepository

interface JpaCategoryRepository : CategoryRepository, JpaRepository<Category, Long> {
    override fun findAll(): List<Category>

    override fun save(category: Category): Category

    override fun existsByCode_Code(code: String): Boolean
}
