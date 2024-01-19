package br.clayder.catalog.admin.domain.category

import br.clayder.catalog.admin.domain.AggregateRoot
import br.clayder.catalog.admin.domain.validation.CategoryValidator
import br.clayder.catalog.admin.domain.validation.ValidationHandler
import java.time.Instant

class Category private constructor(

    val anId: CategoryID,
    val aName: String,
    val aDescription: String,
    val isActive: Boolean,
    val aCreatedAt: Instant,
    val aUpdatedAt: Instant,
    val aDeletedAt: Instant? = null

): AggregateRoot<CategoryID>(anId) {

    companion object {
        fun newCategory(
            aName: String,
            aDescription: String,
            isActive: Boolean
        ): Category {

            val id = CategoryID.unique()
            val now = Instant.now()

            return Category(
                anId = id,
                aName = aName,
                aDescription = aDescription,
                isActive = isActive,
                aCreatedAt = now,
                aUpdatedAt = now
            )
        }
    }

    override fun validate(handle: ValidationHandler) {
        CategoryValidator(this, handle).validate()
    }

}
