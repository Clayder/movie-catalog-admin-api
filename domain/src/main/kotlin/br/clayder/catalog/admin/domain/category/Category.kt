package br.clayder.catalog.admin.domain.category

import br.clayder.catalog.admin.domain.AggregateRoot
import br.clayder.catalog.admin.domain.validation.CategoryValidator
import br.clayder.catalog.admin.domain.validation.ValidationHandler
import java.time.Instant

class Category private constructor(

    val anId: CategoryID = CategoryID.unique() ,
    val aName: String,
    val aDescription: String

): AggregateRoot<CategoryID>(anId) {

    var aDeletedAt: Instant? = null
        private set
    var isActive: Boolean = true
        private set

    var aUpdatedAt: Instant = Instant.now()
        private set

    var aCreatedAt: Instant = Instant.now()
        private set

    companion object {
        fun newCategory(
            aName: String,
            aDescription: String
        ): Category {

            return Category(
                aName = aName,
                aDescription = aDescription,
            )
        }

        fun newDeactivateCategory(
            aName: String,
            aDescription: String
        ): Category {
            return newCategory(aName, aDescription).deactivate()
        }
    }

    fun deactivate(): Category {

        if(aDeletedAt == null) {
            aDeletedAt = Instant.now()
        }

        isActive = false
        aUpdatedAt = Instant.now()

        return this
    }

    fun activate(): Category {

        aDeletedAt = null
        isActive = true
        aUpdatedAt = Instant.now()

        return this
    }

    override fun validate(handle: ValidationHandler) {
        CategoryValidator(this, handle).validate()
    }

}
