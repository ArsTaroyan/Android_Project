package am.a_t.mobilemarcet.domain.useCase

import am.a_t.mobilemarcet.data.viewState.ViewState
import am.a_t.mobilemarcet.domain.iteractors.LoginUseCase
import am.a_t.mobilemarcet.domain.repo.Repository
import am.a_t.mobilemarcet.model.Login
import am.a_t.mobilemarcet.model.UserData

class LoginUseCaseImpl(private val repository: Repository) : LoginUseCase {
    override suspend fun login(login: Login): ViewState<UserData> = repository.login(login)
}