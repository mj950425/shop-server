package com.example.shop.support

import com.example.shop.category.domain.Category
import com.example.shop.category.domain.CategoryRepository
import com.example.shop.partner.domain.Partner
import com.example.shop.partner.domain.PartnerRepository
import com.example.shop.product.partner.domain.PartnerProduct
import com.example.shop.product.partner.domain.ProductRepository
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal

@Service
class CommonDataInserter(
    private val productRepository: ProductRepository,
    private val partnerRepository: PartnerRepository,
    private val categoryRepository: CategoryRepository,
    private val entityManager: EntityManager,
) {
    @Transactional
    fun insertTestData() {
        val categories =
            listOf(
                Category.of("상의"),
                Category.of("아우터"),
                Category.of("바지"),
                Category.of("스니커즈"),
                Category.of("가방"),
                Category.of("모자"),
                Category.of("양말"),
                Category.of("액세서리"),
            )
        batchInsert(categories)

        val partners =
            listOf(
                Partner.of("A"),
                Partner.of("B"),
                Partner.of("C"),
                Partner.of("D"),
                Partner.of("E"),
                Partner.of("F"),
                Partner.of("G"),
                Partner.of("H"),
                Partner.of("I"),
            )
        batchInsert(partners)

        val products =
            listOf(
                PartnerProduct.of(BigDecimal(11200), "상의", "A"),
                PartnerProduct.of(BigDecimal(10500), "상의", "B"),
                PartnerProduct.of(BigDecimal(10000), "상의", "C"),
                PartnerProduct.of(BigDecimal(10100), "상의", "D"),
                PartnerProduct.of(BigDecimal(10700), "상의", "E"),
                PartnerProduct.of(BigDecimal(11200), "상의", "F"),
                PartnerProduct.of(BigDecimal(10500), "상의", "G"),
                PartnerProduct.of(BigDecimal(10800), "상의", "H"),
                PartnerProduct.of(BigDecimal(11400), "상의", "I"),
                PartnerProduct.of(BigDecimal(5500), "아우터", "A"),
                PartnerProduct.of(BigDecimal(5900), "아우터", "B"),
                PartnerProduct.of(BigDecimal(6200), "아우터", "C"),
                PartnerProduct.of(BigDecimal(5100), "아우터", "D"),
                PartnerProduct.of(BigDecimal(5000), "아우터", "E"),
                PartnerProduct.of(BigDecimal(7200), "아우터", "F"),
                PartnerProduct.of(BigDecimal(5800), "아우터", "G"),
                PartnerProduct.of(BigDecimal(6300), "아우터", "H"),
                PartnerProduct.of(BigDecimal(6700), "아우터", "I"),
                PartnerProduct.of(BigDecimal(4200), "바지", "A"),
                PartnerProduct.of(BigDecimal(3800), "바지", "B"),
                PartnerProduct.of(BigDecimal(3300), "바지", "C"),
                PartnerProduct.of(BigDecimal(3000), "바지", "D"),
                PartnerProduct.of(BigDecimal(3800), "바지", "E"),
                PartnerProduct.of(BigDecimal(4000), "바지", "F"),
                PartnerProduct.of(BigDecimal(3900), "바지", "G"),
                PartnerProduct.of(BigDecimal(3100), "바지", "H"),
                PartnerProduct.of(BigDecimal(3200), "바지", "I"),
                PartnerProduct.of(BigDecimal(9000), "스니커즈", "A"),
                PartnerProduct.of(BigDecimal(9100), "스니커즈", "B"),
                PartnerProduct.of(BigDecimal(9200), "스니커즈", "C"),
                PartnerProduct.of(BigDecimal(9500), "스니커즈", "D"),
                PartnerProduct.of(BigDecimal(9900), "스니커즈", "E"),
                PartnerProduct.of(BigDecimal(9300), "스니커즈", "F"),
                PartnerProduct.of(BigDecimal(9200), "스니커즈", "G"),
                PartnerProduct.of(BigDecimal(9700), "스니커즈", "H"),
                PartnerProduct.of(BigDecimal(9500), "스니커즈", "I"),
                PartnerProduct.of(BigDecimal(2000), "가방", "A"),
                PartnerProduct.of(BigDecimal(2100), "가방", "B"),
                PartnerProduct.of(BigDecimal(2200), "가방", "C"),
                PartnerProduct.of(BigDecimal(2500), "가방", "D"),
                PartnerProduct.of(BigDecimal(2300), "가방", "E"),
                PartnerProduct.of(BigDecimal(2100), "가방", "F"),
                PartnerProduct.of(BigDecimal(2200), "가방", "G"),
                PartnerProduct.of(BigDecimal(2100), "가방", "H"),
                PartnerProduct.of(BigDecimal(2400), "가방", "I"),
                PartnerProduct.of(BigDecimal(1700), "모자", "A"),
                PartnerProduct.of(BigDecimal(2000), "모자", "B"),
                PartnerProduct.of(BigDecimal(1900), "모자", "C"),
                PartnerProduct.of(BigDecimal(1500), "모자", "D"),
                PartnerProduct.of(BigDecimal(1800), "모자", "E"),
                PartnerProduct.of(BigDecimal(1600), "모자", "F"),
                PartnerProduct.of(BigDecimal(1700), "모자", "G"),
                PartnerProduct.of(BigDecimal(1600), "모자", "H"),
                PartnerProduct.of(BigDecimal(1700), "모자", "I"),
                PartnerProduct.of(BigDecimal(1800), "양말", "A"),
                PartnerProduct.of(BigDecimal(2000), "양말", "B"),
                PartnerProduct.of(BigDecimal(2200), "양말", "C"),
                PartnerProduct.of(BigDecimal(2400), "양말", "D"),
                PartnerProduct.of(BigDecimal(2100), "양말", "E"),
                PartnerProduct.of(BigDecimal(2300), "양말", "F"),
                PartnerProduct.of(BigDecimal(2000), "양말", "G"),
                PartnerProduct.of(BigDecimal(2000), "양말", "H"),
                PartnerProduct.of(BigDecimal(1700), "양말", "I"),
                PartnerProduct.of(BigDecimal(2300), "액세서리", "A"),
                PartnerProduct.of(BigDecimal(2200), "액세서리", "B"),
                PartnerProduct.of(BigDecimal(2100), "액세서리", "C"),
                PartnerProduct.of(BigDecimal(2000), "액세서리", "D"),
                PartnerProduct.of(BigDecimal(2100), "액세서리", "E"),
                PartnerProduct.of(BigDecimal(1900), "액세서리", "F"),
                PartnerProduct.of(BigDecimal(2100), "액세서리", "G"),
                PartnerProduct.of(BigDecimal(2000), "액세서리", "H"),
                PartnerProduct.of(BigDecimal(2400), "액세서리", "I"),
            )
        batchInsert(products)
    }

    @Transactional
    fun clearDatabase() {
        productRepository.deleteAllInBatch()
        partnerRepository.deleteAllInBatch()
        categoryRepository.deleteAllInBatch()

        entityManager.createNativeQuery("ALTER TABLE products ALTER COLUMN id RESTART WITH 1").executeUpdate()
        entityManager.createNativeQuery("ALTER TABLE partners ALTER COLUMN id RESTART WITH 1").executeUpdate()
        entityManager.createNativeQuery("ALTER TABLE categories ALTER COLUMN id RESTART WITH 1").executeUpdate()
    }

    private fun <T> batchInsert(
        entities: List<T>,
        batchSize: Int = 50,
    ) {
        for (i in entities.indices) {
            entityManager.persist(entities[i])
            if (i > 0 && i % batchSize == 0) {
                entityManager.flush()
                entityManager.clear()
            }
        }
        entityManager.flush()
        entityManager.clear()
    }
}
