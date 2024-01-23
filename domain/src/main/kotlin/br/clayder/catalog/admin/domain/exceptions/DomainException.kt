package br.clayder.catalog.admin.domain.exceptions

import br.clayder.catalog.admin.domain.validation.Error

class DomainException private constructor(
    private val aMessage: String,
    val errors: List<Error>
): NoStacktraceException(aMessage) {

    companion object {

        fun with(anErrors: List<Error>): DomainException {
            return DomainException("", anErrors)
        }

        fun with(anError: Error): DomainException {
            return DomainException("", listOf(anError))
        }
    }
}
