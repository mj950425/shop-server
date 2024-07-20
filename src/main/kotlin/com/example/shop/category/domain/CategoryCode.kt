package com.example.shop.category.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import org.hibernate.annotations.Comment

@Embeddable
class CategoryCode private constructor(
    @Column(name = "code", columnDefinition = "varchar(255)", nullable = false)
    @Comment("카테고리 코드")
    val code: String,
) {
    companion object {
        fun of(code: String): CategoryCode {
            require(code.length in 1..255) { "카테고리 코드는 1자 이상 255자 이하여야 합니다." }
            return CategoryCode(code)
        }
    }
}
