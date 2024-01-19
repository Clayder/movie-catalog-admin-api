package br.clayder.catalog.admin.domain.validation.handler

import br.clayder.catalog.admin.domain.exceptions.DomainException
import br.clayder.catalog.admin.domain.validation.Error
import br.clayder.catalog.admin.domain.validation.ValidationHandler

class ThrowsValidationHandler: ValidationHandler  {

    override fun append(anError: Error): ValidationHandler {
        throw DomainException.with(listOf(anError))
    }

    override fun append(anHandler: ValidationHandler): ValidationHandler {
        throw DomainException.with(anHandler.getErrors())
    }

    override fun validate(aValidation: ValidationHandler.Validation): ValidationHandler {
        try {
            aValidation.validate()
        } catch (ex: Exception) {
            throw DomainException.with(
                listOf(Error(ex.message.toString()))
            )
        }

        return this
    }

    override fun getErrors(): List<Error> {
        return listOf()
    }
}
