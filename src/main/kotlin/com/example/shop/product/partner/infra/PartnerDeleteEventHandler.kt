package com.example.shop.product.partner.infra

import com.example.shop.partner.domain.PartnerDeletedEvent
import com.example.shop.product.partner.application.ProductPartnerService
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Service
class PartnerDeleteEventHandler(
    private val productPartnerService: ProductPartnerService,
) {
    @Async
    @TransactionalEventListener(
        classes = [PartnerDeletedEvent::class],
        phase = TransactionPhase.AFTER_COMMIT,
    )
    fun handle(event: PartnerDeletedEvent) {
        productPartnerService.deleteByPartnerId(event.id)
    }
}
