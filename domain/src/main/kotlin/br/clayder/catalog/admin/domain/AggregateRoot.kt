package br.clayder.catalog.admin.domain

abstract class AggregateRoot<ID: Identifier> protected constructor(
    override val id: ID
): Entity<ID>(id)
