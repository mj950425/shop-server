package com.example.shop.product.partner.infra

import com.example.shop.partner.domain.PartnerRepository
import com.example.shop.product.partner.domain.ProductBrandNameClient
import org.springframework.stereotype.Service

@Service
class ProductBrandNameClientImpl(
    private val partnerRepository: PartnerRepository,
) : ProductBrandNameClient {
    override fun getBrandName(partnerId: Long): String {
        return partnerRepository.findPartnerById(partnerId)?.getBrandName()
            ?: throw IllegalArgumentException("아이디가 ${partnerId}인 파트너가 존재하지 않습니다.")
    }
}
