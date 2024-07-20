package com.example.shop.product.partner.application

import com.example.shop.product.partner.domain.FakeProductBrandNameClient
import com.example.shop.product.partner.domain.FakeProductCategoryNameClient
import com.example.shop.product.partner.domain.FakeProductRepository
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ProductPartnerServiceTest : DescribeSpec({
    val fakeProductRepository = FakeProductRepository()
    val productPartnerService =
        ProductPartnerService(
            FakeProductBrandNameClient(),
            FakeProductCategoryNameClient(),
            fakeProductRepository,
        )

    describe("ProductPartnerService 클래스의") {

        describe("register 메소드는") {

            beforeTest {
                fakeProductRepository.clear()
            }

            context("판매가, 파트너 아이디, 카테고리 아이디가 주어졌을때") {
                it("상품을 등록하고, 반환한다") {
                    val savedProductId =
                        productPartnerService.register(
                            partnerId = 1L,
                            categoryId = 1L,
                            salePrice = "10000".toBigDecimal(),
                        )

                    savedProductId shouldBe 1L
                }
            }

            context("존재하지않는 파트너 아이디가 주어졌을때") {
                it("예외를 던진다") {
                    shouldThrow<IllegalArgumentException> {
                        productPartnerService.register(
                            partnerId = Long.MAX_VALUE,
                            categoryId = 1L,
                            salePrice = "10000".toBigDecimal(),
                        )
                    }
                }
            }

            context("존재하지않는 카테고리 아이디가 주어졌을때") {
                it("예외를 던진다") {
                    shouldThrow<IllegalArgumentException> {
                        productPartnerService.register(
                            partnerId = 1L,
                            categoryId = Long.MAX_VALUE,
                            salePrice = "10000".toBigDecimal(),
                        )
                    }
                }
            }
        }
    }
})
