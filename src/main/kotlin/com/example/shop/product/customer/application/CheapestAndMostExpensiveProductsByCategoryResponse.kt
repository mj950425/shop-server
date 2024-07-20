package com.example.shop.product.customer.application

import com.example.shop.product.customer.domain.CustomerProduct
import java.math.BigDecimal

data class CheapestAndMostExpensiveProductsByCategoryResponse(
    val categoryCode: String,
    val cheapest: CheapestProductByCategory,
    val mostExpensive: MostExpensiveProductByCategory,
) {
    data class CheapestProductByCategory(
        val id: Long,
        val brandName: String,
        val salePrice: BigDecimal,
    )

    data class MostExpensiveProductByCategory(
        val id: Long,
        val brandName: String,
        val salePrice: BigDecimal,
    )

    companion object {
        fun of(
            cheapestProductByCategory: CustomerProduct,
            mostExpensiveProductByCategory: CustomerProduct,
        ): CheapestAndMostExpensiveProductsByCategoryResponse {
            return CheapestAndMostExpensiveProductsByCategoryResponse(
                categoryCode = cheapestProductByCategory.categoryCode,
                cheapest =
                    CheapestProductByCategory(
                        id = cheapestProductByCategory.id!!,
                        brandName = cheapestProductByCategory.brandName,
                        salePrice = cheapestProductByCategory.salePrice,
                    ),
                mostExpensive =
                    MostExpensiveProductByCategory(
                        id = mostExpensiveProductByCategory.id!!,
                        brandName = mostExpensiveProductByCategory.brandName,
                        salePrice = mostExpensiveProductByCategory.salePrice,
                    ),
            )
        }
    }
}
