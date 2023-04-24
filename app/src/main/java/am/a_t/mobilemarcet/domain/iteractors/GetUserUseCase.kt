package am.a_t.mobilemarcet.domain.iteractors

import am.a_t.mobilemarcet.model.UserData

interface GetUserUseCase {
    suspend fun getUserData(): UserData?
}