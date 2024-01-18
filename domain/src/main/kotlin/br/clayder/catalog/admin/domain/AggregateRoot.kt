package br.clayder.catalog.admin.domain

open class AggregateRoot<ID: Identifier> protected constructor(
    override val id: ID
): Entity<ID>(id)
