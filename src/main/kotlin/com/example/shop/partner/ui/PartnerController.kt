package com.example.shop.partner.ui

import com.example.shop.partner.application.PartnerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/api/v1/partners")
class PartnerController(
    private val partnerService: PartnerService,
) {
    @PostMapping
    fun create(
        @RequestBody request: CreatePartnerRequest,
    ): ResponseEntity<Long> =
        ResponseEntity
            .created(
                URI.create("/api/v1/partners"),
            ).body(partnerService.create(request.name))

    @DeleteMapping("/{partnerId}")
    fun delete(
        @PathVariable partnerId: Long,
    ): ResponseEntity<Unit> {
        partnerService.delete(partnerId)
        return ResponseEntity.notFound().build()
    }
}
