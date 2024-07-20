package com.example.shop.partner.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import org.hibernate.annotations.Comment

@Embeddable
class BrandName private constructor(
    @Column(name = "brand_name", columnDefinition = "varchar(1024)", nullable = false)
    @Comment("브랜드 이름")
    val name: String,
) {
    companion object {
        fun of(name: String): BrandName {
            require(name.length in 1..1024) { "브랜드 이름은 1자 이상 1024자 이하여야 합니다." }
            return BrandName(name)
        }
    }
}
