package com.example.shop.product.partner.domain

import com.example.shop.support.CommonFakeRepository

class FakeProductRepository :
    CommonFakeRepository<PartnerProduct>(),
    ProductRepository {
    override fun findProductById(id: Long): PartnerProduct? = inMemoryDb[id]

    override fun save(product: PartnerProduct): PartnerProduct {
        setId(product)
        inMemoryDb[product.id!!] = product
        return product
    }

    override fun findAllByBrandName(brandName: String): List<PartnerProduct> = inMemoryDb.values.filter { it.brandName == brandName }
}
