package am.a_t.mobilemarcet.domain.useCase

import am.a_t.mobilemarcet.domain.iteractors.ReadUseCase
import am.a_t.mobilemarcet.domain.repo.Repository

class ReadUseCaseImpl(private val repository: Repository): ReadUseCase {
    override suspend fun readUserLocalData(): Boolean = repository.readUserLocalData()
}