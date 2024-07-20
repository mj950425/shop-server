package com.example.shop.product.partner.ui

import com.example.shop.product.partner.application.ProductPartnerService
import com.example.shop.product.partner.application.ProductResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/api/v1/products")
class ProductPartnerController(
    private val productPartnerService: ProductPartnerService,
) {
    @GetMapping("/partners/{partnerId}")
    fun findAllByPartnerId(
        @PathVariable partnerId: Long,
    ): ResponseEntity<List<ProductResponse>> {
        return ResponseEntity.ok(productPartnerService.findAllByPartnerId(partnerId))
    }

    @PostMapping
    fun register(
        @RequestBody request: RegisterProductRequest,
    ): ResponseEntity<Long> {
        return ResponseEntity.created(
            URI.create("/api/v1/products"),
        ).body(
            productPartnerService.register(request.partnerId, request.categoryId, request.salePrice),
        )
    }

    @DeleteMapping("/{id}")
    fun delete(
        @PathVariable id: Long,
    ): ResponseEntity<Void> {
        productPartnerService.delete(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody request: UpdateProductRequest,
    ): ResponseEntity<Long> {
        productPartnerService.update(id, request.categoryId, request.salePrice)
        return ResponseEntity.ok(id)
    }
}
