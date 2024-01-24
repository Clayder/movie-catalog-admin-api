package br.clayder.catalog.admin.domain.validation

import br.clayder.catalog.admin.domain.category.Category

class CategoryValidator(
    private val category: Category,
    private val handler: ValidationHandler
): Validator(handler) {

    override fun validate() {
        checkNameConstraints()
    }

    private fun checkNameConstraints() {
        val name = category.aName
        if (name.isEmpty()) {
            validationHandler().append(Error("'name' should not be empty"))
        }
        if (name.isBlank()) {
            validationHandler().append(Error("'name' should not be blank"))
        }
        val length = name.trim().length
        if (length > 255 || length < 3) {
            validationHandler().append(Error("'name' must be between 3 and 255 characters"))
        }
    }
}
