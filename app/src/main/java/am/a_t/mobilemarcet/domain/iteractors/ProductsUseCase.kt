package am.a_t.mobilemarcet.domain.iteractors

import am.a_t.mobilemarcet.data.viewState.ViewState
import am.a_t.mobilemarcet.model.Products

interface ProductsUseCase {
    suspend fun product(): ViewState<Products>
}