package br.clayder.catalog.admin.application

import br.clayder.catalog.admin.domain.category.Category

class UseCase {

    fun execute(): Category {
        return Category.newCategory(
            "Category",
            "Description",
            true
        )
    }
}