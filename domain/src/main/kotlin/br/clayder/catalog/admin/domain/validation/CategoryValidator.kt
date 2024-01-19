package br.clayder.catalog.admin.domain.validation

import br.clayder.catalog.admin.domain.category.Category

class CategoryValidator(
    private val category: Category,
    private val handler: ValidationHandler
): Validator(handler) {

    override fun validate() {
        if (category.aName.isEmpty()) {
            validationHandler().append(Error("'name' should not be empty"))
        }
    }
}
