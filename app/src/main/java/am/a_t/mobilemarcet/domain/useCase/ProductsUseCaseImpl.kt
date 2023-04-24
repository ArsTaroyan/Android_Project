package am.a_t.mobilemarcet.domain.useCase

import am.a_t.mobilemarcet.data.viewState.ViewState
import am.a_t.mobilemarcet.domain.iteractors.ProductsUseCase
import am.a_t.mobilemarcet.domain.repo.Repository
import am.a_t.mobilemarcet.model.Products

class ProductsUseCaseImpl(private val repository: Repository) : ProductsUseCase {
    override suspend fun product(): ViewState<Products> = repository.product()
}