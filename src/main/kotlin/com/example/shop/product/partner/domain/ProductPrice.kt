package com.example.shop.product.partner.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import org.hibernate.annotations.Comment
import java.math.BigDecimal

@Embeddable
class ProductPrice private constructor(
    @Column(name = "sale_price", nullable = false)
    @Comment("상품 판매 가격")
    val amount: BigDecimal,
) {
    companion object {
        fun of(salePrice: BigDecimal): ProductPrice {
            require(salePrice > BigDecimal.ZERO) { "상품 판매 가격은 0 초과이어야 합니다." }
            return ProductPrice(salePrice)
        }
    }
}
