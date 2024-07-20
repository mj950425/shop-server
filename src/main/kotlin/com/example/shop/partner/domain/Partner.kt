package com.example.shop.partner.domain

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
import org.springframework.context.ApplicationEventPublisher

@Entity
@Table(name = "partners")
@SQLRestriction("deleted_at is NULL")
class Partner private constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint", nullable = false)
    @Comment("파트너 아이디")
    val id: Long? = null,
    @Embedded
    val brandName: BrandName,
) : BaseEntity() {
    companion object {
        fun of(name: String): Partner = Partner(brandName = BrandName.of(name))
    }

    fun deletePartner(eventPublisher: ApplicationEventPublisher) {
        this.delete()
        eventPublisher.publishEvent(PartnerDeletedEvent(id = id!!))
    }

    fun getBrandName(): String = brandName.name
}
