package com.example.shop.category.application

import com.example.shop.category.domain.Category
import com.example.shop.category.domain.FakeCategoryRepository
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CategoryServiceTest : DescribeSpec({
    describe("CategoryService 클래스의") {
        val fakeCategoryRepository = FakeCategoryRepository()
        val categoryService = CategoryService(fakeCategoryRepository)

        describe("create 메소드는") {

            beforeTest {
                fakeCategoryRepository.clear()
            }

            context("카테고리 코드가 주어졌을때") {
                it("카테고리를 등록하고, 반환한다") {
                    val savedCategoryId = categoryService.create("상의")

                    savedCategoryId shouldBe 1L
                }
            }

            context("이미 존재하는 카테고리 코드가 주어졌을때") {
                it("예외를 던진다") {
                    fakeCategoryRepository.save(Category.of("상의"))
                    shouldThrow<IllegalArgumentException> { categoryService.create("상의") }
                }
            }
        }
    }
})
