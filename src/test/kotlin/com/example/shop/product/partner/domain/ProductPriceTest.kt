package com.example.shop.product.partner.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class ProductPriceTest : DescribeSpec() {
    init {
        describe("ProductPrice 클래스의") {
            describe("of 메소드는") {
                context("가격이 주어졌을때") {
                    it("상품 가격 정보를 반환한다") {
                        val productPrice = ProductPrice.of(1000.toBigDecimal())
                        productPrice.amount shouldBe 1000.toBigDecimal()
                    }
                }

                context("0 이하의 가격이 주어졌을때") {
                    it("예외를 던진다") {
                        shouldThrow<IllegalArgumentException> {
                            ProductPrice.of(BigDecimal.ZERO)
                        }
                    }
                }
            }
        }
    }
}
