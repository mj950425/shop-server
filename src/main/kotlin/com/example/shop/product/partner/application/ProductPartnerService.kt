package com.example.shop.product.partner.application

import com.example.shop.product.partner.domain.PartnerProduct
import com.example.shop.product.partner.domain.ProductBrandNameClient
import com.example.shop.product.partner.domain.ProductCategoryNameClient
import com.example.shop.product.partner.domain.ProductRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal

@Service
@Transactional
class ProductPartnerService(
    private val productBrandNameClient: ProductBrandNameClient,
    private val productCategoryNameClient: ProductCategoryNameClient,
    private val productRepository: ProductRepository,
) {
    fun register(
        partnerId: Long,
        categoryId: Long,
        salePrice: BigDecimal,
    ): Long {
        val brandName = productBrandNameClient.getBrandName(partnerId)
        val categoryCode = productCategoryNameClient.getCategoryCode(categoryId)
        val saved =
            productRepository.save(
                PartnerProduct.of(
                    brandName = brandName,
                    categoryCode = categoryCode,
                    salePrice = salePrice,
                ),
            )
        return saved.id!!
    }

    fun delete(id: Long) {
        val product =
            productRepository.findProductById(id)
                ?: throw IllegalArgumentException("아이디가 ${id}인 상품이 없습니다.")

        product.delete()
    }

    fun update(
        id: Long,
        categoryId: Long,
        salePrice: BigDecimal,
    ) {
        val product =
            productRepository.findProductById(id)
                ?: throw IllegalArgumentException("아이디가 ${id}인 상품이 없습니다.")

        val categoryCode = productCategoryNameClient.getCategoryCode(categoryId)

        product.update(categoryCode, salePrice)
    }

    fun findAllByPartnerId(partnerId: Long): List<ProductResponse> {
        val brandName = productBrandNameClient.getBrandName(partnerId)

        return productRepository.findAllByBrandName(brandName).map {
            ProductResponse(
                id = it.id!!,
                categoryCode = it.categoryCode,
                salePrice = it.salePrice.amount,
            )
        }
    }

    fun deleteByPartnerId(partnerId: Long) {
        val products = productRepository.findAllByBrandName(productBrandNameClient.getBrandName(partnerId))
        products.forEach { it.delete() }
    }
}
