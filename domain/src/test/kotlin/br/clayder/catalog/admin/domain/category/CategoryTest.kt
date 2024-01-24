package br.clayder.catalog.admin.domain.category

import br.clayder.catalog.admin.domain.exceptions.DomainException
import br.clayder.catalog.admin.domain.validation.handler.ThrowsValidationHandler
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

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

        assertDoesNotThrow { actualCategory.validate(ThrowsValidationHandler()) }

        Assertions.assertNotNull(actualCategory)
        Assertions.assertNotNull(actualCategory.id)
        Assertions.assertEquals(expectedName, actualCategory.aName)
        Assertions.assertEquals(expectedDescription, actualCategory.aDescription)
        Assertions.assertTrue(actualCategory.isActive)
        Assertions.assertNotNull(actualCategory.aCreatedAt)
        Assertions.assertNotNull(actualCategory.aUpdatedAt)
        Assertions.assertNull(actualCategory.aDeletedAt)
    }

    @Test
    fun `Given an invalid empty name when call new category and validate then should receive error`() {
        val expectedName = ""
        val expectedErrorCount = 1
        val expectedErrorMessage = "'name' should not be empty"
        val expectedDescription = "A categoria mais assistida"
        val expectedIsActive = true

        val actualCategory = Category.newCategory(
            expectedName,
            expectedDescription,
            expectedIsActive
        )

        val actualException = assertThrows(
            DomainException::class.java
        ) {
            actualCategory.validate(
                ThrowsValidationHandler()
            )
        }

        Assertions.assertEquals(expectedErrorCount, actualException.errors.size)
        Assertions.assertEquals(expectedErrorMessage, actualException.errors[0].message)
    }

    @Test
    fun `Given an invalid name length than 3 when call new category and validate then should receive error`() {
        val expectedName = "Fi "
        val expectedErrorCount = 1
        val expectedErrorMessage = "'name' must be between 3 and 255 characters"
        val expectedDescription = "A categoria mais assistida"
        val expectedIsActive = true

        val actualCategory = Category.newCategory(
            expectedName,
            expectedDescription,
            expectedIsActive
        )

        val actualException = assertThrows(
            DomainException::class.java
        ) {
            actualCategory.validate(
                ThrowsValidationHandler()
            )
        }

        Assertions.assertEquals(expectedErrorCount, actualException.errors.size)
        Assertions.assertEquals(expectedErrorMessage, actualException.errors[0].message)
    }

    @Test
    fun `Given an invalid name length more then 255 characters when call new category and validate then should receive error`() {
        val expectedName = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ultricies feugiat sapien, sed vestibulum " +
                "justo pharetra eget. Duis ut lectus fermentum, dictum ante sit amet, ultricies ex. Duis venenatis eget dui ut aliquam." +
                " Donec porttitor sapien leo. Sed ac orci risus"
        val expectedErrorCount = 1
        val expectedErrorMessage = "'name' must be between 3 and 255 characters"
        val expectedDescription = "A categoria mais assistida"
        val expectedIsActive = true

        val actualCategory = Category.newCategory(
            expectedName,
            expectedDescription,
            expectedIsActive
        )

        val actualException = assertThrows(
            DomainException::class.java
        ) {
            actualCategory.validate(
                ThrowsValidationHandler()
            )
        }

        Assertions.assertEquals(expectedErrorCount, actualException.errors.size)
        Assertions.assertEquals(expectedErrorMessage, actualException.errors[0].message)
    }

    @Test
    fun `Given a valid empty description when call new category and validate then should receive ok`() {
        val expectedName = "Test"
        val expectedDescription = " "
        val expectedIsActive = true

        val actualCategory = Category.newCategory(
            expectedName,
            expectedDescription,
            expectedIsActive
        )

        assertDoesNotThrow { actualCategory.validate(ThrowsValidationHandler()) }

        Assertions.assertNotNull(actualCategory)
        Assertions.assertNotNull(actualCategory.id)
        Assertions.assertEquals(expectedName, actualCategory.aName)
        Assertions.assertEquals(expectedDescription, actualCategory.aDescription)
        Assertions.assertTrue(actualCategory.isActive)
        Assertions.assertNotNull(actualCategory.aCreatedAt)
        Assertions.assertNotNull(actualCategory.aUpdatedAt)
        Assertions.assertNull(actualCategory.aDeletedAt)
    }

    @Test
    fun `Given a valid false isActive when call new category and validate then should receive ok`() {
        val expectedName = "Test"
        val expectedDescription = "Test"
        val expectedIsActive = false

        val actualCategory = Category.newCategory(
            expectedName,
            expectedDescription,
            expectedIsActive
        )

        assertDoesNotThrow { actualCategory.validate(ThrowsValidationHandler()) }

        Assertions.assertNotNull(actualCategory)
        Assertions.assertNotNull(actualCategory.id)
        Assertions.assertEquals(expectedName, actualCategory.aName)
        Assertions.assertEquals(expectedDescription, actualCategory.aDescription)
        Assertions.assertFalse(actualCategory.isActive)
        Assertions.assertNotNull(actualCategory.aCreatedAt)
        Assertions.assertNotNull(actualCategory.aUpdatedAt)
        Assertions.assertNull(actualCategory.aDeletedAt)
    }
}
