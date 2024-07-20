package com.example.shop.category.domain

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

@Entity
@Table(name = "categories")
@SQLRestriction("deleted_at is NULL")
class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint", nullable = false)
    @Comment("카테고리 아이디")
    val id: Long? = null,
    @Embedded
    val code: CategoryCode,
) : BaseEntity() {
    companion object {
        fun of(code: String): Category = Category(code = CategoryCode.of(code))
    }

    fun getCode(): String = code.code
}
