package com.example.shop.category.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CategoryCodeTest : DescribeSpec({
    describe("CategoryCode 클래스의") {
        describe("of 메소드는") {
            context("카테고리 코드가 주어졌을때") {
                it("카테고리 코드를 생성하고, 반환한다") {
                    val categoryCode = CategoryCode.of("A")
                    categoryCode.code shouldBe "A"
                }
            }

            context("0 이하 또는 256 이상의 카테고리 코드로 주어지면") {
                val stringBuilder = StringBuilder()
                for (i in 1..256) {
                    stringBuilder.append("a")
                }
                val longString = stringBuilder.toString()

                it("IllegalArgumentException을 던진다") {
                    shouldThrow<IllegalArgumentException> { CategoryCode.of("") }
                    shouldThrow<IllegalArgumentException> { CategoryCode.of(longString) }
                }
            }
        }
    }
})
