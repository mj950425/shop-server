package com.example.shop.product.partner.domain

import com.example.shop.support.domain.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.Comment
import org.hibernate.annotations.SQLRestriction
import java.math.BigDecimal

@Entity
@Table(name = "products")
@SQLRestriction("deleted_at is NULL")
class PartnerProduct private constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint", nullable = false)
    @Comment("상품 아이디")
    val id: Long? = null,
    @Embedded
    var salePrice: ProductPrice,
    @Column(name = "category_code", columnDefinition = "varchar(255)", nullable = false)
    @Comment("카테고리 코드")
    var categoryCode: String,
    @Column(name = "brand_name", columnDefinition = "varchar(255)", nullable = false)
    @Comment("브랜드 이름")
    val brandName: String,
) : BaseEntity() {
    fun update(
        categoryCode: String,
        salePrice: BigDecimal,
    ): PartnerProduct {
        this.salePrice = ProductPrice.of(salePrice)
        this.categoryCode = categoryCode
        return this
    }

    companion object {
        fun of(
            salePrice: BigDecimal,
            categoryCode: String,
            brandName: String,
        ): PartnerProduct =
            PartnerProduct(
                salePrice = ProductPrice.of(salePrice),
                categoryCode = categoryCode,
                brandName = brandName,
            )
    }

    fun getSalePrice(): BigDecimal = salePrice.amount
}
