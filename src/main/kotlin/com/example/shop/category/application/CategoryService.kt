package com.example.shop.category.application

import com.example.shop.category.domain.Category
import com.example.shop.category.domain.CategoryRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CategoryService(
    private val categoryRepository: CategoryRepository,
) {
    fun create(code: String): Long {
        require(categoryRepository.existsByCode_Code(code).not()) { "${code}는 이미 존재하는 카테고리 코드입니다." }
        val saved = categoryRepository.save(Category.of(code))
        return saved.id!!
    }

    fun findAll(): CategoriesResponse {
        return CategoriesResponse(
            categories =
                categoryRepository.findAll().map {
                    CategoriesResponse.Category(
                        it.id!!,
                        it.code.code,
                    )
                },
        )
    }
}
