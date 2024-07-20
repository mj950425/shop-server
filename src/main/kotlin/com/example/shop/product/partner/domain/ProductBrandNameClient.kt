package com.example.shop.product.partner.domain

interface ProductBrandNameClient {
    fun getBrandName(partnerId: Long): String
}
