package com.example.shop.product.customer.infra

import com.example.shop.product.customer.domain.CustomerProduct
import com.example.shop.product.customer.domain.CustomerProductRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface JpaCustomerProductRepository :
    JpaRepository<CustomerProduct, Long>,
    CustomerProductRepository {
    @Query(
        value = """
            SELECT p.* FROM products p
            JOIN (
                SELECT category_code, MIN(sale_price) as min_price
                FROM products
                GROUP BY category_code
            ) min_price_products
            ON p.category_code = min_price_products.category_code
            AND p.sale_price = min_price_products.min_price
        """,
        nativeQuery = true,
    )
    override fun findCheapestProductsPerCategory(): List<CustomerProduct>

    @Query(
        value = """
            SELECT p.* FROM products p
            WHERE p.category_code = :categoryCode
            ORDER BY p.sale_price
            LIMIT 1
        """,
        nativeQuery = true,
    )
    override fun findCheapestProductByCategoryCode(
        @Param("categoryCode") categoryCode: String,
    ): CustomerProduct

    @Query(
        value = """
            SELECT p.* FROM products p
            WHERE p.category_code = :categoryCode
            ORDER BY p.sale_price DESC
            LIMIT 1
        """,
        nativeQuery = true,
    )
    override fun findMostExpensiveProductByCategoryCode(
        @Param("categoryCode") categoryCode: String,
    ): CustomerProduct

    @Query(
        """
            SELECT p.*
            FROM products p
            JOIN (
                SELECT brand_name
                FROM products
                GROUP BY brand_name
                HAVING SUM(sale_price) = (
                    SELECT MIN(total_price)
                    FROM (
                        SELECT brand_name, SUM(sale_price) AS total_price
                        FROM products
                        GROUP BY brand_name
                    ) AS total_price_per_brands
                )
            ) AS min_brand
            ON p.brand_name = min_brand.brand_name
        """,
        nativeQuery = true,
    )
    override fun findCheapestBrand(): List<CustomerProduct>
}
