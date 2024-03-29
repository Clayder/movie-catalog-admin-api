package br.clayder.catalog.admin.application

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class UseCaseTest {

    @Test
    fun testCreateUseCase() {
        Assertions.assertNotNull(UseCase())
        Assertions.assertNotNull(UseCase().execute())
    }
}