package com.example.shop.partner.domain

import com.example.shop.support.CommonFakeRepository

class FakePartnerRepository :
    CommonFakeRepository<Partner>(),
    PartnerRepository {
    override fun save(partner: Partner): Partner {
        setId(partner)
        inMemoryDb[partner.id!!] = partner
        return partner
    }

    override fun existsByBrandName_Name(name: String): Boolean =
        inMemoryDb.values.filter { it.deletedAt == null }.any { it.getBrandName() == name }

    override fun findPartnerById(partnerId: Long): Partner? = inMemoryDb[partnerId].takeIf { it?.deletedAt == null }
}
