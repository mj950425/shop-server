package com.example.shop.product.partner.domain

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class PartnerProductTest() : DescribeSpec() {
    init {
        describe("PartnerProduct 클래스의") {
            describe("of 메소드는") {
                context("가격, 카테고리 코드, 브랜드 이름이 주어졌을때") {
                    it("상품 정보를 반환한다") {
                        val product =
                            PartnerProduct.of(
                                salePrice = 1000.toBigDecimal(),
                                categoryCode = "상의",
                                brandName = "A",
                            )

                        assertSoftly {
                            product.getSalePrice() shouldBe 1000.toBigDecimal()
                            product.categoryCode shouldBe "상의"
                            product.brandName shouldBe "A"
                        }
                    }
                }

                context("0 보다 작은 가격이 주어졌을때") {
                    it("예외를 던진다") {
                        shouldThrow<IllegalArgumentException> {
                            PartnerProduct.of(
                                salePrice = BigDecimal.ZERO,
                                categoryCode = "상의",
                                brandName = "A",
                            )
                        }
                    }
                }
            }
        }
    }
}
