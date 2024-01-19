package br.clayder.catalog.admin.domain.validation

abstract class Validator protected constructor(
    private val handler: ValidationHandler
) {

    protected fun validationHandler(): ValidationHandler {
        return handler
    }

    abstract fun validate()
}
