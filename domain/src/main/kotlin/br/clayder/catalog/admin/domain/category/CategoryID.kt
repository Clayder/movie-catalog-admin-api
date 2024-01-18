package br.clayder.catalog.admin.domain.category

import br.clayder.catalog.admin.domain.Identifier
import java.util.*

class CategoryID private constructor(
    val value: String
) : Identifier() {

    companion object {
        fun unique(): CategoryID {
            return CategoryID.from(UUID.randomUUID())
        }

        fun from(anId: String): CategoryID {
            return CategoryID(anId)
        }

        private fun from(anId: UUID): CategoryID {
            return CategoryID(anId.toString())
        }

    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CategoryID

        return value == other.value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

}
