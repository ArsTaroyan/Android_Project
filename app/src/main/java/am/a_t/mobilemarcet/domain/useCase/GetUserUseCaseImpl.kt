package am.a_t.mobilemarcet.domain.useCase

import am.a_t.mobilemarcet.domain.iteractors.GetUserUseCase
import am.a_t.mobilemarcet.domain.repo.Repository
import am.a_t.mobilemarcet.model.UserData

class GetUserUseCaseImpl(private val repository: Repository) : GetUserUseCase {
    override suspend fun getUserData(): UserData? = repository.getUserData()
}