package com.example.shop.support

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.sql.Timestamp
import java.time.LocalDateTime

@Service
class CommonDataInserter(
    private val jdbcTemplate: JdbcTemplate,
) {
    @Transactional
    fun insertTestData() {
        val now = Timestamp.valueOf(LocalDateTime.now())

        val categoriesSql = """
            INSERT INTO categories (code, created_at, updated_at, deleted_at) VALUES (?, ?, ?, ?)
        """
        val categoriesParams =
            listOf(
                arrayOf("상의", now, now, null),
                arrayOf("아우터", now, now, null),
                arrayOf("바지", now, now, null),
                arrayOf("스니커즈", now, now, null),
                arrayOf("가방", now, now, null),
                arrayOf("모자", now, now, null),
                arrayOf("양말", now, now, null),
                arrayOf("액세서리", now, now, null),
            )
        jdbcTemplate.batchUpdate(categoriesSql, categoriesParams)

        val partnersSql = """
            INSERT INTO partners (brand_name, created_at, updated_at, deleted_at) VALUES (?, ?, ?, ?)
        """
        val partnersParams =
            listOf(
                arrayOf("A", now, now, null),
                arrayOf("B", now, now, null),
                arrayOf("C", now, now, null),
                arrayOf("D", now, now, null),
                arrayOf("E", now, now, null),
                arrayOf("F", now, now, null),
                arrayOf("G", now, now, null),
                arrayOf("H", now, now, null),
                arrayOf("I", now, now, null),
            )
        jdbcTemplate.batchUpdate(partnersSql, partnersParams)

        val productsSql = """
            INSERT INTO products (sale_price, category_code, brand_name, created_at, updated_at, deleted_at) VALUES (?, ?, ?, ?, ?, ?)
        """
        val productsParams =
            listOf(
                arrayOf(BigDecimal(11200), "상의", "A", now, now, null),
                arrayOf(BigDecimal(10500), "상의", "B", now, now, null),
                arrayOf(BigDecimal(10000), "상의", "C", now, now, null),
                arrayOf(BigDecimal(10100), "상의", "D", now, now, null),
                arrayOf(BigDecimal(10700), "상의", "E", now, now, null),
                arrayOf(BigDecimal(11200), "상의", "F", now, now, null),
                arrayOf(BigDecimal(10500), "상의", "G", now, now, null),
                arrayOf(BigDecimal(10800), "상의", "H", now, now, null),
                arrayOf(BigDecimal(11400), "상의", "I", now, now, null),
                arrayOf(BigDecimal(5500), "아우터", "A", now, now, null),
                arrayOf(BigDecimal(5900), "아우터", "B", now, now, null),
                arrayOf(BigDecimal(6200), "아우터", "C", now, now, null),
                arrayOf(BigDecimal(5100), "아우터", "D", now, now, null),
                arrayOf(BigDecimal(5000), "아우터", "E", now, now, null),
                arrayOf(BigDecimal(7200), "아우터", "F", now, now, null),
                arrayOf(BigDecimal(5800), "아우터", "G", now, now, null),
                arrayOf(BigDecimal(6300), "아우터", "H", now, now, null),
                arrayOf(BigDecimal(6700), "아우터", "I", now, now, null),
                arrayOf(BigDecimal(4200), "바지", "A", now, now, null),
                arrayOf(BigDecimal(3800), "바지", "B", now, now, null),
                arrayOf(BigDecimal(3300), "바지", "C", now, now, null),
                arrayOf(BigDecimal(3000), "바지", "D", now, now, null),
                arrayOf(BigDecimal(3800), "바지", "E", now, now, null),
                arrayOf(BigDecimal(4000), "바지", "F", now, now, null),
                arrayOf(BigDecimal(3900), "바지", "G", now, now, null),
                arrayOf(BigDecimal(3100), "바지", "H", now, now, null),
                arrayOf(BigDecimal(3200), "바지", "I", now, now, null),
                arrayOf(BigDecimal(9000), "스니커즈", "A", now, now, null),
                arrayOf(BigDecimal(9100), "스니커즈", "B", now, now, null),
                arrayOf(BigDecimal(9200), "스니커즈", "C", now, now, null),
                arrayOf(BigDecimal(9500), "스니커즈", "D", now, now, null),
                arrayOf(BigDecimal(9900), "스니커즈", "E", now, now, null),
                arrayOf(BigDecimal(9300), "스니커즈", "F", now, now, null),
                arrayOf(BigDecimal(9200), "스니커즈", "G", now, now, null),
                arrayOf(BigDecimal(9700), "스니커즈", "H", now, now, null),
                arrayOf(BigDecimal(9500), "스니커즈", "I", now, now, null),
                arrayOf(BigDecimal(2000), "가방", "A", now, now, null),
                arrayOf(BigDecimal(2100), "가방", "B", now, now, null),
                arrayOf(BigDecimal(2200), "가방", "C", now, now, null),
                arrayOf(BigDecimal(2500), "가방", "D", now, now, null),
                arrayOf(BigDecimal(2300), "가방", "E", now, now, null),
                arrayOf(BigDecimal(2100), "가방", "F", now, now, null),
                arrayOf(BigDecimal(2200), "가방", "G", now, now, null),
                arrayOf(BigDecimal(2100), "가방", "H", now, now, null),
                arrayOf(BigDecimal(2400), "가방", "I", now, now, null),
                arrayOf(BigDecimal(1700), "모자", "A", now, now, null),
                arrayOf(BigDecimal(2000), "모자", "B", now, now, null),
                arrayOf(BigDecimal(1900), "모자", "C", now, now, null),
                arrayOf(BigDecimal(1500), "모자", "D", now, now, null),
                arrayOf(BigDecimal(1800), "모자", "E", now, now, null),
                arrayOf(BigDecimal(1600), "모자", "F", now, now, null),
                arrayOf(BigDecimal(1700), "모자", "G", now, now, null),
                arrayOf(BigDecimal(1600), "모자", "H", now, now, null),
                arrayOf(BigDecimal(1700), "모자", "I", now, now, null),
                arrayOf(BigDecimal(1800), "양말", "A", now, now, null),
                arrayOf(BigDecimal(2000), "양말", "B", now, now, null),
                arrayOf(BigDecimal(2200), "양말", "C", now, now, null),
                arrayOf(BigDecimal(2400), "양말", "D", now, now, null),
                arrayOf(BigDecimal(2100), "양말", "E", now, now, null),
                arrayOf(BigDecimal(2300), "양말", "F", now, now, null),
                arrayOf(BigDecimal(2000), "양말", "G", now, now, null),
                arrayOf(BigDecimal(2000), "양말", "H", now, now, null),
                arrayOf(BigDecimal(1700), "양말", "I", now, now, null),
                arrayOf(BigDecimal(2300), "액세서리", "A", now, now, null),
                arrayOf(BigDecimal(2200), "액세서리", "B", now, now, null),
                arrayOf(BigDecimal(2100), "액세서리", "C", now, now, null),
                arrayOf(BigDecimal(2000), "액세서리", "D", now, now, null),
                arrayOf(BigDecimal(2100), "액세서리", "E", now, now, null),
                arrayOf(BigDecimal(1900), "액세서리", "F", now, now, null),
                arrayOf(BigDecimal(2100), "액세서리", "G", now, now, null),
                arrayOf(BigDecimal(2000), "액세서리", "H", now, now, null),
                arrayOf(BigDecimal(2400), "액세서리", "I", now, now, null),
            )
        jdbcTemplate.batchUpdate(productsSql, productsParams)
    }

    @Transactional
    fun clearDatabase() {
        val deleteProductsSql = "DELETE FROM products"
        val deletePartnersSql = "DELETE FROM partners"
        val deleteCategoriesSql = "DELETE FROM categories"

        val resetProductsIdSql = "ALTER TABLE products ALTER COLUMN id RESTART WITH 1"
        val resetPartnersIdSql = "ALTER TABLE partners ALTER COLUMN id RESTART WITH 1"
        val resetCategoriesIdSql = "ALTER TABLE categories ALTER COLUMN id RESTART WITH 1"

        jdbcTemplate.update(deleteProductsSql)
        jdbcTemplate.update(deletePartnersSql)
        jdbcTemplate.update(deleteCategoriesSql)

        jdbcTemplate.update(resetProductsIdSql)
        jdbcTemplate.update(resetPartnersIdSql)
        jdbcTemplate.update(resetCategoriesIdSql)
    }
}
