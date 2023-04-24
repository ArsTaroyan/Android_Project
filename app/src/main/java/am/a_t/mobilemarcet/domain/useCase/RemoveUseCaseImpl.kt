package am.a_t.mobilemarcet.domain.useCase

import am.a_t.mobilemarcet.domain.iteractors.RemoveUseCase
import am.a_t.mobilemarcet.domain.repo.Repository

class RemoveUseCaseImpl(private val repository: Repository) : RemoveUseCase {
    override suspend fun removeUserData(): Boolean = repository.removeUserData()
}