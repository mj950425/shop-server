package com.example.shop.product.customer.ui

import com.example.shop.product.customer.application.CheapestAndMostExpensiveProductsByCategoryResponse
import com.example.shop.product.customer.application.CheapestPartnerResponse
import com.example.shop.product.customer.application.CheapestProductPerCategoriesResponse
import com.example.shop.product.customer.application.CustomerProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/products")
class CustomerProductController(
    private val customerProductService: CustomerProductService,
) {
    @GetMapping("/cheapest-per-categories")
    fun getCheapestProductsPerCategories(): ResponseEntity<CheapestProductPerCategoriesResponse> {
        return ResponseEntity.ok(
            customerProductService.getCheapestProductPerCategories(),
        )
    }

    @GetMapping("/cheapest-partner")
    fun getCheapestPartner(): ResponseEntity<CheapestPartnerResponse> {
        return ResponseEntity.ok(
            customerProductService.getCheapestPartnerResponse(),
        )
    }

    @GetMapping("/cheapest-and-most-expensive")
    fun getCheapestAndMostExpensiveProductsByCategory(
        @RequestParam categoryCode: String,
    ): ResponseEntity<CheapestAndMostExpensiveProductsByCategoryResponse> {
        return ResponseEntity.ok(
            customerProductService.getCheapestAndMostExpensiveProductByCategory(categoryCode),
        )
    }
}
