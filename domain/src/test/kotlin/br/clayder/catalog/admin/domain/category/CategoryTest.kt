package br.clayder.catalog.admin.domain.category

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CategoryTest {

    @Test
    fun `Given a valid params when call new category then instantiate a category`() {
        val expectedName = "Filmes"
        val expectedDescription = "A categoria mais assistida"
        val expectedIsActive = true

        val actualCategory = Category.newCategory(
            expectedName,
            expectedDescription,
            expectedIsActive
        )

        Assertions.assertNotNull(actualCategory)
        Assertions.assertNotNull(actualCategory.id)
        Assertions.assertEquals(expectedName, actualCategory.aName)
        Assertions.assertEquals(expectedDescription, actualCategory.aDescription)
        Assertions.assertEquals(expectedIsActive, actualCategory.isActive)
        Assertions.assertNotNull(actualCategory.aCreatedAt)
        Assertions.assertNotNull(actualCategory.aUpdatedAt)
        Assertions.assertNull(actualCategory.aDeletedAt)
    }
}
