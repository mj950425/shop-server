package com.example.shop.product.partner.domain

class FakeProductBrandNameClient : ProductBrandNameClient {
    override fun getBrandName(partnerId: Long): String {
        return when (partnerId) {
            1L -> "A"
            2L -> "B"
            3L -> "C"
            else -> throw IllegalArgumentException("파트너 아이디가 ${partnerId}인 브랜드명을 찾을 수 없습니다.")
        }
    }
}
