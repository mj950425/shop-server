package com.example.shop.category.domain

import com.example.shop.support.CommonFakeRepository

class FakeCategoryRepository :
    CommonFakeRepository<Category>(),
    CategoryRepository {
    override fun deleteAllInBatch() {
        inMemoryDb.clear()
    }

    override fun findAll(): List<Category> = inMemoryDb.values.toList()

    override fun save(category: Category): Category {
        setId(category)
        inMemoryDb[category.id!!] = category
        return category
    }

    override fun findById(categoryId: Long): Category? = inMemoryDb[categoryId]

    override fun existsByCode_Code(code: String): Boolean = inMemoryDb.values.any { it.getCode() == code }
}
