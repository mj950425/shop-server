package com.example.shop.product.partner.ui

import com.example.shop.product.partner.application.ProductResponse
import com.example.shop.product.partner.domain.ProductRepository
import com.example.shop.support.CommonAcceptanceTest
import com.example.shop.support.CommonDataInserter
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe
import org.codehaus.groovy.runtime.ScriptBytecodeAdapter.compareTo
import org.springframework.boot.test.web.server.LocalServerPort
import java.math.BigDecimal

class PartnerProductAcceptanceTest(
    @LocalServerPort
    override val port: Int,
    private val commonDataInserter: CommonDataInserter,
    private val productRepository: ProductRepository,
) : CommonAcceptanceTest() {
    init {
        beforeSpec {
            commonDataInserter.clearDatabase()
            commonDataInserter.insertTestData()
        }

        given("파트너가 로그인한 뒤에") {
            `when`("파트너의 아이디로 상품들을 조회했을때") {
                then("파트너의 아이디로 등록된 상품들을 응답한다.") {
                    val response =
                        commonRequestSpec()
                            .get("/api/v1/products/partners/1")
                            .then()
                            .log()
                            .everything()
                            .extract()
                            .response()

                    val productResponses: List<ProductResponse> =
                        response.jsonPath().getList(".", ProductResponse::class.java)

                    productResponses.size shouldBe 8

                    val expectedProducts =
                        listOf(
                            ProductResponse(1, "상의", BigDecimal("11200.0")),
                            ProductResponse(10, "아우터", BigDecimal("5500.0")),
                            ProductResponse(19, "바지", BigDecimal("4200.0")),
                            ProductResponse(28, "스니커즈", BigDecimal("9000.0")),
                            ProductResponse(37, "가방", BigDecimal("2000.0")),
                            ProductResponse(46, "모자", BigDecimal("1700.0")),
                            ProductResponse(55, "양말", BigDecimal("1800.0")),
                            ProductResponse(64, "액세서리", BigDecimal("2300.0")),
                        )

                    productResponses shouldContainExactlyInAnyOrder expectedProducts
                }
            }

            `when`("상품을 등록했을때") {
                then("상품을 등록하고 상품의 아이디를 응답한다.") {
                    val request =
                        RegisterProductRequest(
                            partnerId = 1,
                            categoryId = 1,
                            salePrice = 10000.toBigDecimal(),
                        )

                    val response =
                        commonRequestSpec()
                            .body(request)
                            .post("/api/v1/products")
                            .then()
                            .log()
                            .everything()
                            .extract()
                            .response()

                    response.statusCode shouldBe 201
                }
            }

            `when`("상품을 삭제했을때") {
                then("상품을 삭제한다.") {
                    val response =
                        commonRequestSpec()
                            .delete("/api/v1/products/1")
                            .then()
                            .log()
                            .everything()
                            .extract()
                            .response()

                    response.statusCode shouldBe 204
                    productRepository.findProductById(1) shouldBe null
                }
            }

            `when`("상품을 수정했을때") {
                then("상품을 수정하고 상품의 아이디를 응답한다.") {
                    val request =
                        UpdateProductRequest(
                            categoryId = 1,
                            salePrice = 99999.toBigDecimal(),
                        )
                    val response =
                        commonRequestSpec()
                            .body(request)
                            .put("/api/v1/products/2")
                            .then()
                            .log()
                            .everything()
                            .extract()
                            .response()

                    val updated = productRepository.findProductById(2)

                    response.statusCode shouldBe 200
                    compareTo(99999.00.toBigDecimal(), updated?.getSalePrice()) shouldBe 0
                }
            }
        }
    }
}
