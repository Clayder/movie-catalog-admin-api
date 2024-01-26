package br.clayder.catalog.admin.domain.category

import br.clayder.catalog.admin.domain.pagination.Pagination

interface ICategoryGateway {

    fun create(aCategory: Category): Category
    fun deleteById(anId: CategoryID)
    fun findById(anId: CategoryID)
    fun update(aCategory: Category): Category
    fun findAll(aQuery: CategorySearchQuery): Pagination<Category>

}
