package br.clayder.catalog.admin.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CategoryTest {

    @Test
    fun testCategory() {
        Assertions.assertNotNull(Category("popopop"))
    }
}