package com.example.shop.product.customer.application

import com.example.shop.product.customer.domain.CustomerProduct
import java.math.BigDecimal

data class CheapestProductPerCategoriesResponse(
    val totalPrice: BigDecimal,
    val cheapestProducts: List<CheapestProduct>,
) {
    data class CheapestProduct(
        val id: Long,
        val categoryCode: String,
        val brandName: String,
        val salePrice: BigDecimal,
    )

    companion object {
        fun of(
            totalPrice: BigDecimal,
            cheapestProductPerCategories: List<CustomerProduct>,
        ): CheapestProductPerCategoriesResponse {
            return CheapestProductPerCategoriesResponse(
                totalPrice = totalPrice,
                cheapestProducts =
                    cheapestProductPerCategories.map {
                        CheapestProduct(
                            id = it.id!!,
                            categoryCode = it.categoryCode,
                            brandName = it.brandName,
                            salePrice = it.salePrice,
                        )
                    },
            )
        }
    }
}
