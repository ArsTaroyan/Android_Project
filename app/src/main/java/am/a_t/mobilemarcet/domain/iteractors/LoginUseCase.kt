package am.a_t.mobilemarcet.domain.iteractors

import am.a_t.mobilemarcet.data.viewState.ViewState
import am.a_t.mobilemarcet.model.Login
import am.a_t.mobilemarcet.model.UserData

interface LoginUseCase {
    suspend fun login(login: Login): ViewState<UserData>
}