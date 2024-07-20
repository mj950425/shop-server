package com.example.shop.product.customer.application

import com.example.shop.product.customer.domain.CustomerProductRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class CustomerProductService(
    private val productRepository: CustomerProductRepository,
) {
    fun getCheapestProductPerCategories(): CheapestProductPerCategoriesResponse {
        val cheapestProductByCategories = productRepository.findCheapestProductsPerCategory()

        check(cheapestProductByCategories.isNotEmpty()) { "아직 어떠한 상품도 존재하지 않습니다." }

        val totalPrice = cheapestProductByCategories.sumOf { it.salePrice }
        return CheapestProductPerCategoriesResponse.of(totalPrice, cheapestProductByCategories)
    }

    fun getCheapestAndMostExpensiveProductByCategory(categoryCode: String): CheapestAndMostExpensiveProductsByCategoryResponse {
        val cheapestProductByCategory = productRepository.findCheapestProductByCategoryCode(categoryCode)
        val mostExpensiveProductByCategory = productRepository.findMostExpensiveProductByCategoryCode(categoryCode)

        checkNotNull(cheapestProductByCategory) { "아직 어떠한 상품도 존재하지 않습니다." }
        checkNotNull(mostExpensiveProductByCategory) { "아직 어떠한 상품도 존재하지 않습니다." }

        return CheapestAndMostExpensiveProductsByCategoryResponse.of(
            cheapestProductByCategory,
            mostExpensiveProductByCategory,
        )
    }

    fun getCheapestPartnerResponse(): CheapestPartnerResponse {
        val products = productRepository.findCheapestBrand()

        check(products.isNotEmpty()) { "아직 어떠한 상품도 존재하지 않습니다." }
        check(products.all { it.brandName == products.first().brandName }) { "브랜드 이름이 같지 않습니다." }

        return CheapestPartnerResponse(
            brandName = products.first().brandName,
            totalPrice = products.sumOf { it.salePrice },
            products =
                products.map {
                    CheapestPartnerResponse.Product(
                        id = it.id!!,
                        categoryCode = it.categoryCode,
                        salePrice = it.salePrice,
                    )
                },
        )
    }
}
