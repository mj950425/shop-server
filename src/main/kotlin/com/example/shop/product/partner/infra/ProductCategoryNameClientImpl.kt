package com.example.shop.product.partner.infra

import com.example.shop.category.domain.CategoryRepository
import com.example.shop.product.partner.domain.ProductCategoryNameClient
import org.springframework.stereotype.Service

@Service
class ProductCategoryNameClientImpl(
    private val categoryRepository: CategoryRepository,
) : ProductCategoryNameClient {
    override fun getCategoryCode(categoryId: Long): String {
        val category =
            categoryRepository.findById(categoryId)
                ?: throw IllegalArgumentException("아이디가 ${categoryId}인 카테고리가 존재하지 않습니다.")
        return category.getCode()
    }
}
