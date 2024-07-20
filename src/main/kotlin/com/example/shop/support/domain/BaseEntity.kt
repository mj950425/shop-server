package com.example.shop.support.domain

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.Comment
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity {
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "datetime")
    @Comment("생성일시")
    var createdAt: LocalDateTime? = LocalDateTime.now()

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, updatable = true, columnDefinition = "datetime")
    @Comment("수정일시")
    var updatedAt: LocalDateTime? = LocalDateTime.now()

    @Column(name = "deleted_at", nullable = true, updatable = true, columnDefinition = "datetime")
    @Comment("삭제일시")
    var deletedAt: LocalDateTime? = null

    fun delete() {
        deletedAt = LocalDateTime.now()
    }
}
