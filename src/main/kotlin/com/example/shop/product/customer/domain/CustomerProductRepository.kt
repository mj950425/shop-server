package com.example.shop.product.customer.domain

interface CustomerProductRepository {
    fun findCheapestProductsPerCategory(): List<CustomerProduct>

    fun findCheapestProductByCategoryCode(categoryCode: String): CustomerProduct?

    fun findMostExpensiveProductByCategoryCode(categoryCode: String): CustomerProduct?

    fun findCheapestBrand(): List<CustomerProduct>
}
