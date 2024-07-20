package com.example.shop.product.customer.ui

import com.example.shop.support.CommonAcceptanceTest
import com.example.shop.support.CommonDataInserter
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter.compareTo
import org.springframework.boot.test.web.server.LocalServerPort

class CustomerProductAcceptanceTest(
    @LocalServerPort
    override val port: Int,
    private val commonDataInserter: CommonDataInserter,
) : CommonAcceptanceTest() {
    init {
        beforeSpec {
            commonDataInserter.clearDatabase()
            commonDataInserter.insertTestData()
        }

        given("고객이 로그인한 뒤에") {
            `when`("카테고리별로 가장 저렴한 브랜드의 상품들을 조회했을떄") {
                then("카테고리별로 가장 저렴한 브랜드와 가격을 응답한다.") {
                    val response =
                        commonRequestSpec()
                            .get("/api/v1/products/cheapest-per-categories")
                            .then()
                            .log()
                            .everything()
                            .extract()
                            .response()

                    val jsonPathEvaluator = response.jsonPath()

                    val totalPrice = jsonPathEvaluator.getFloat("totalPrice")
                    totalPrice shouldBe 34100.00f

                    val cheapestProducts = jsonPathEvaluator.getList<Map<String, Any>>("cheapestProducts")
                    cheapestProducts.size shouldBe 8

                    val expectedCheapestProducts =
                        listOf(
                            mapOf("id" to 3, "categoryCode" to "상의", "brandName" to "C", "salePrice" to 10000.00f),
                            mapOf("id" to 14, "categoryCode" to "아우터", "brandName" to "E", "salePrice" to 5000.00f),
                            mapOf("id" to 22, "categoryCode" to "바지", "brandName" to "D", "salePrice" to 3000.00f),
                            mapOf("id" to 28, "categoryCode" to "스니커즈", "brandName" to "A", "salePrice" to 9000.00f),
                            mapOf("id" to 37, "categoryCode" to "가방", "brandName" to "A", "salePrice" to 2000.00f),
                            mapOf("id" to 49, "categoryCode" to "모자", "brandName" to "D", "salePrice" to 1500.00f),
                            mapOf("id" to 63, "categoryCode" to "양말", "brandName" to "I", "salePrice" to 1700.00f),
                            mapOf("id" to 69, "categoryCode" to "액세서리", "brandName" to "F", "salePrice" to 1900.00f),
                        )

                    cheapestProducts shouldContainExactlyInAnyOrder expectedCheapestProducts
                }
            }

            `when`("모든 카테고리의 상품 가격 합이 가장 저렴한 파트너의 상품들을 조회했을때") {
                then("카테고리별 상품의 가격과 총합을 응답한다.") {
                    val response =
                        commonRequestSpec()
                            .get("/api/v1/products/cheapest-partner")
                            .then()
                            .log()
                            .everything()
                            .extract()
                            .response()

                    val jsonPathEvaluator = response.jsonPath()

                    response.statusCode shouldBe 200

                    val brandName = jsonPathEvaluator.getString("brandName")
                    brandName shouldBe "D"

                    val totalPrice = jsonPathEvaluator.getFloat("totalPrice")
                    totalPrice shouldBe 36100.00f

                    val products = jsonPathEvaluator.getList<Map<String, Any>>("products")
                    products.size shouldBe 8

                    val expectedProducts =
                        listOf(
                            mapOf("id" to 4, "categoryCode" to "상의", "salePrice" to 10100.00f),
                            mapOf("id" to 13, "categoryCode" to "아우터", "salePrice" to 5100.00f),
                            mapOf("id" to 22, "categoryCode" to "바지", "salePrice" to 3000.00f),
                            mapOf("id" to 31, "categoryCode" to "스니커즈", "salePrice" to 9500.00f),
                            mapOf("id" to 40, "categoryCode" to "가방", "salePrice" to 2500.00f),
                            mapOf("id" to 49, "categoryCode" to "모자", "salePrice" to 1500.00f),
                            mapOf("id" to 58, "categoryCode" to "양말", "salePrice" to 2400.00f),
                            mapOf("id" to 67, "categoryCode" to "액세서리", "salePrice" to 2000.00f),
                        )

                    products shouldContainExactlyInAnyOrder expectedProducts
                }
            }

            `when`("특정 카테고리에서 가장 저렴한 브랜드의 상품을 조회했을떄") {
                then("상품의 가격과 총합을 응답한다.") {
                    val response =
                        commonRequestSpec()
                            .get("/api/v1/products/cheapest-and-most-expensive?categoryCode=상의")
                            .then()
                            .log()
                            .everything()
                            .extract()
                            .response()

                    response.statusCode shouldBe 200

                    val jsonPathEvaluator = response.jsonPath()

                    val categoryCode = jsonPathEvaluator.getString("categoryCode")
                    categoryCode shouldBe "상의"

                    val cheapestBrandName = jsonPathEvaluator.getString("cheapest.brandName")
                    val cheapestSalePrice = jsonPathEvaluator.getFloat("cheapest.salePrice")
                    cheapestBrandName shouldBe "C"
                    compareTo(cheapestSalePrice, 10000.00.toBigDecimal()) shouldBe 0

                    val mostExpensiveBrandName = jsonPathEvaluator.getString("mostExpensive.brandName")
                    val mostExpensiveSalePrice = jsonPathEvaluator.getFloat("mostExpensive.salePrice")
                    mostExpensiveBrandName shouldBe "I"
                    compareTo(mostExpensiveSalePrice, 11400.00.toBigDecimal()) shouldBe 0
                }
            }
        }
    }
}
