package com.example.shop.category.domain

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CategoryTest : DescribeSpec({
    describe("Category 클래스의") {
        describe("of 메소드는") {
            context("카테고리 이름이 주어졌을때") {
                it("카테고리를 생성하고, 반환한다") {
                    val category = Category.of("A")
                    category.code.code shouldBe "A"
                }
            }

            context("0 이하 또는 256 이상의 카테고리 이름으로 주어지면") {
                val stringBuilder = StringBuilder()
                for (i in 1..256) {
                    stringBuilder.append("a")
                }
                val longString = stringBuilder.toString()

                it("IllegalArgumentException을 던진다") {

                    assertSoftly {
                        shouldThrow<IllegalArgumentException> { Category.of("") }
                        shouldThrow<IllegalArgumentException> { Category.of(longString) }
                    }
                }
            }
        }
    }
})
