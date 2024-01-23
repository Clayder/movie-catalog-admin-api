package br.clayder.catalog.admin.domain.exceptions

open class NoStacktraceException : RuntimeException {
    constructor(message: String) : super(message, null)
    constructor(message: String, cause: Throwable) : super(message, cause, true, true)
}
