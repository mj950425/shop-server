package com.example.shop.partner.application

import com.example.shop.partner.domain.Partner
import com.example.shop.partner.domain.PartnerRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PartnerService(
    private val partnerRepository: PartnerRepository,
    private val publisher: ApplicationEventPublisher,
) {
    fun create(name: String): Long {
        require(!partnerRepository.existsByBrandName_Name(name)) { "이미 존재하는 브랜드 이름입니다." }
        val saved = partnerRepository.save(Partner.of(name))
        return saved.id!!
    }

    fun delete(id: Long) {
        val partner = partnerRepository.findPartnerById(id)
        partner?.deletePartner(publisher)
    }
}
