package com.example.shop.product.partner.domain

interface ProductRepository {
    fun deleteAllInBatch()

    fun findProductById(id: Long): PartnerProduct?

    fun save(product: PartnerProduct): PartnerProduct

    fun findAllByBrandName(brandName: String): List<PartnerProduct>
}
