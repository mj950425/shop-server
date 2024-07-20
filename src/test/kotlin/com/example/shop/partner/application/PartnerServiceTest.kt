package com.example.shop.partner.application

import com.example.shop.partner.domain.FakePartnerRepository
import com.example.shop.partner.domain.Partner
import com.example.shop.partner.domain.PartnerDeletedEvent
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import org.springframework.context.ApplicationEventPublisher

class PartnerServiceTest :
    DescribeSpec({
        val fakePartnerRepository = FakePartnerRepository()
        val publisher = mockk<ApplicationEventPublisher>()
        val partnerService = PartnerService(fakePartnerRepository, publisher)

        describe("PartnerService 클래스의") {

            beforeTest {
                fakePartnerRepository.clear()
            }

            describe("create 메소드는") {
                context("브랜드 이름이 주어졌을때") {
                    it("파트너를 등록하고, 반환한다") {
                        val savedPartnerId = partnerService.create("A")
                        savedPartnerId shouldBe 1L
                    }
                }

                context("이미 존재하는 브랜드 이름이 주어졌을때") {
                    it("예외를 던진다") {
                        fakePartnerRepository.save(Partner.of("A"))
                        shouldThrow<IllegalArgumentException> {
                            partnerService.create("A")
                        }
                    }
                }
            }

            describe("delete 메소드는") {
                context("파트너 아이디가 주어졌을때") {
                    it("파트너를 삭제한다") {
                        val savedPartnerId = partnerService.create("A")
                        every { publisher.publishEvent(PartnerDeletedEvent(savedPartnerId)) } just runs
                        partnerService.delete(savedPartnerId)
                        fakePartnerRepository.findPartnerById(savedPartnerId) shouldBe null
                    }
                }
            }
        }
    })
