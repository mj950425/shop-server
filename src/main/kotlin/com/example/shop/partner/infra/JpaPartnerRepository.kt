package com.example.shop.partner.infra

import com.example.shop.partner.domain.Partner
import com.example.shop.partner.domain.PartnerRepository
import org.springframework.data.jpa.repository.JpaRepository

interface JpaPartnerRepository :
    PartnerRepository,
    JpaRepository<Partner, Long> {
    override fun save(partner: Partner): Partner

    override fun existsByBrandName_Name(name: String): Boolean

    override fun findPartnerById(partnerId: Long): Partner?
}
