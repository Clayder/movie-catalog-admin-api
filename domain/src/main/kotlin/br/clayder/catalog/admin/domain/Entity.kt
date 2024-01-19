package br.clayder.catalog.admin.domain

import br.clayder.catalog.admin.domain.validation.ValidationHandler

abstract class Entity<ID: Identifier> protected constructor(
    open val id: ID
) {

    abstract fun validate(handle: ValidationHandler)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Entity<*>

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

}
