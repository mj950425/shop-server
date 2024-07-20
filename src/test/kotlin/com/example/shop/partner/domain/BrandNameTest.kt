package com.example.shop.partner.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class BrandNameTest() : DescribeSpec() {
    init {
        describe("BrandName 클래스의") {
            describe("of 메소드는") {
                context("브랜드 이름이 주어졌을때") {
                    it("브랜드 이름을 생성하고, 반환한다") {
                        val brandName = BrandName.of("A")
                        brandName.name shouldBe "A"
                    }
                }

                context("empty string이 브랜드 이름으로 주어지면") {
                    it("IllegalArgumentException을 던진다") {
                        shouldThrow<IllegalArgumentException> {
                            BrandName.of("")
                        }
                    }
                }
            }
        }
    }
}
