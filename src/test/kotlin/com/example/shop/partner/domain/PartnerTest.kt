package com.example.shop.partner.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import org.springframework.context.ApplicationEventPublisher

class PartnerTest : DescribeSpec() {
    init {
        describe("Partner 클래스의") {
            describe("of 메소드는") {
                context("브랜드 이름이 주어지면") {
                    it("파트너를 생성하고, 반환한다") {
                        val partner = Partner.of("A")
                        partner.brandName.name shouldBe "A"
                    }
                }

                context("empty string이 브랜드 이름으로 주어지면") {
                    it("IllegalArgumentException을 던진다") {
                        shouldThrow<IllegalArgumentException> {
                            Partner.of("")
                        }
                    }
                }
            }

            describe("delete 메소드는") {
                val publisher = mockk<ApplicationEventPublisher>()
                val partner = Partner.of("A")
                val repository = FakePartnerRepository()
                val savedPartner = repository.save(partner)
                every { publisher.publishEvent(PartnerDeletedEvent(savedPartner.id!!)) } just runs

                it("파트너를 삭제한다") {
                    partner.deletePartner(publisher)
                    partner.deletedAt shouldNotBe null
                }
            }
        }
    }
}
