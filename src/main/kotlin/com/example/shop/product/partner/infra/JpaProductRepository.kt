package com.example.shop.product.partner.infra

import com.example.shop.product.partner.domain.PartnerProduct
import com.example.shop.product.partner.domain.ProductRepository
import org.springframework.data.jpa.repository.JpaRepository

interface JpaProductRepository : ProductRepository, JpaRepository<PartnerProduct, Long> {
    override fun findProductById(id: Long): PartnerProduct?

    override fun findAllByBrandName(brandName: String): List<PartnerProduct>

    override fun save(product: PartnerProduct): PartnerProduct
}
