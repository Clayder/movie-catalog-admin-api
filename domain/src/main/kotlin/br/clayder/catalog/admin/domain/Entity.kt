package br.clayder.catalog.admin.domain

abstract class Entity<ID: Identifier> protected constructor(
    open val id: ID
) {

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
