package br.clayder.catalog.admin.domain.exceptions

import br.clayder.catalog.admin.domain.validation.Error

class DomainException private constructor(
    val errors: List<Error>
): RuntimeException("", null, true, false) {

    companion object {

        fun with(anErrors: List<Error>): DomainException {
            return DomainException(anErrors)
        }
    }
}
