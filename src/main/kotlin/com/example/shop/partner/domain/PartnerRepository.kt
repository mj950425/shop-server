package com.example.shop.partner.domain

interface PartnerRepository {
    fun deleteAllInBatch()

    fun save(partner: Partner): Partner

    fun existsByBrandName_Name(name: String): Boolean

    fun findPartnerById(partnerId: Long): Partner?
}
