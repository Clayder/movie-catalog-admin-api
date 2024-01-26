package br.clayder.catalog.admin.domain.validation

import br.clayder.catalog.admin.domain.category.Category

private const val NAME_MAX_LENGTH = 255

private const val NAME_MIN_LENGTH = 3

class CategoryValidator(
    private val category: Category,
    private val handler: ValidationHandler
): Validator(handler) {

    override fun validate() {
        checkNameConstraints()
    }

    private fun checkNameConstraints() {
        val name = category.name
        if (name.isEmpty()) {
            validationHandler().append(Error("'name' should not be empty"))
        }
        if (name.isBlank()) {
            validationHandler().append(Error("'name' should not be blank"))
        }
        val length = name.trim().length
        if (length > NAME_MAX_LENGTH || length < NAME_MIN_LENGTH) {
            validationHandler().append(Error("'name' must be between 3 and 255 characters"))
        }
    }
}
