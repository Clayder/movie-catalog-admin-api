package br.clayder.catalog.admin.domain.category

import br.clayder.catalog.admin.domain.AggregateRoot
import br.clayder.catalog.admin.domain.validation.CategoryValidator
import br.clayder.catalog.admin.domain.validation.ValidationHandler
import java.time.Instant

class Category private constructor(

    val anId: CategoryID = CategoryID.unique() ,
    private val aName: String,
    private val aDescription: String,
    private val active: Boolean,

): AggregateRoot<CategoryID>(anId) {

    var name: String = aName
        private set

    var description: String = aDescription
        private set

    var aDeletedAt: Instant? = null
        private set
    var isActive: Boolean = active
        private set

    var aUpdatedAt: Instant = Instant.now()
        private set

    var aCreatedAt: Instant = Instant.now()
        private set

    companion object {
        fun newCategory(
            aName: String,
            aDescription: String,
            isActive: Boolean = true
        ): Category {

            return Category(
                aName = aName,
                aDescription = aDescription,
                active = isActive
            )
        }

    }

    fun deactivate(): Category {

        aDeletedAt = aDeletedAt ?: Instant.now()
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

    fun update(
        aName: String,
        aDescription: String,
        isActive: Boolean
    ): Category {

        when(isActive) {
            true -> activate()
            false -> deactivate()
        }

        this.name = aName
        this.description = aDescription

        return this
    }

    override fun validate(handle: ValidationHandler) {
        CategoryValidator(this, handle).validate()
    }



}
