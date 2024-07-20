package com.example.shop.support

abstract class CommonFakeRepository<T> {
    val inMemoryDb = mutableMapOf<Long, T>()
    private var sequence = 1L

    fun clear() {
        inMemoryDb.clear()
        sequence = 1L
    }

    fun setId(entity: T) {
        val idField = entity!!::class.java.getDeclaredField("id")
        idField.isAccessible = true
        idField.set(entity, sequence++)
    }
}
