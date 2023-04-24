package am.a_t.mobilemarcet.domain.iteractors

interface ReadUseCase {
    suspend fun readUserLocalData(): Boolean
}