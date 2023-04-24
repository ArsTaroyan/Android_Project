package am.a_t.mobilemarcet.domain.repo

import am.a_t.mobilemarcet.data.viewState.ViewState
import am.a_t.mobilemarcet.model.Login
import am.a_t.mobilemarcet.model.Products
import am.a_t.mobilemarcet.model.UserData

interface Repository {
    suspend fun getUserData(): UserData?
    suspend fun removeUserData(): Boolean
    suspend fun readUserLocalData(): Boolean
    suspend fun login(login: Login): ViewState<UserData>
    suspend fun product(): ViewState<Products>
}