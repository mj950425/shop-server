package com.example.shop.product.partner.domain

class FakeProductCategoryNameClient : ProductCategoryNameClient {
    override fun getCategoryCode(categoryId: Long): String {
        return when (categoryId) {
            1L -> "상의"
            2L -> "하의"
            3L -> "바지"
            else -> throw IllegalArgumentException("카테고리 아이디가 ${categoryId}인 카테고리명을 찾을 수 없습니다.")
        }
    }
}
