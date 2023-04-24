package am.a_t.mobilemarcet.domain.iteractors

interface RemoveUseCase {
    suspend fun removeUserData(): Boolean
}