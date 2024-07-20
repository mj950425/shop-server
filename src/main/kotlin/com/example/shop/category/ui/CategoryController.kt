package com.example.shop.category.ui

import com.example.shop.category.application.CategoriesResponse
import com.example.shop.category.application.CategoryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/api/v1/categories")
class CategoryController(
    private val categoryService: CategoryService,
) {
    @PostMapping
    fun create(
        @RequestBody request: CreateCategoryRequest,
    ): ResponseEntity<Long> {
        return ResponseEntity.created(
            URI.create("/api/v1/categories"),
        ).body(categoryService.create(request.code))
    }

    @GetMapping
    fun findAll(): ResponseEntity<CategoriesResponse> {
        return ResponseEntity.ok(categoryService.findAll())
    }
}
