package am.a_t.mobilemarcet.data.repo

import am.a_t.mobilemarcet.data.api.ApiService
import am.a_t.mobilemarcet.data.preferences.Preference
import am.a_t.mobilemarcet.data.preferences.Preference.Companion.USER_LOGIN
import am.a_t.mobilemarcet.data.viewState.ViewState
import am.a_t.mobilemarcet.domain.repo.Repository
import am.a_t.mobilemarcet.extension.convertJsonToString
import am.a_t.mobilemarcet.extension.convertStringToJson
import am.a_t.mobilemarcet.model.Login
import am.a_t.mobilemarcet.model.Products
import am.a_t.mobilemarcet.model.UserData
import android.util.Log

class RepositoryImpl(private val apiService: ApiService, var dataStore: Preference) : Repository {

    override suspend fun getUserData(): UserData? =
        dataStore.getUser(USER_LOGIN)?.convertStringToJson()

    override suspend fun readUserLocalData(): Boolean = dataStore.getUser(USER_LOGIN).isNullOrEmpty()

    override suspend fun removeUserData(): Boolean {
        dataStore.removeUser(USER_LOGIN)
        return dataStore.getUser(USER_LOGIN).isNullOrEmpty()
    }

    override suspend fun login(login: Login): ViewState<UserData> {
        val response = apiService.auth(login)
        return if (response.isSuccessful) {
            dataStore.setUser(USER_LOGIN, response.body().convertJsonToString())
            ViewState.Success(response.body() ?: UserData.emptyUserData())
        } else {
            ViewState.Error(response.code(), response.message())
        }
    }

    override suspend fun product(): ViewState<Products> {
        val response = apiService.getProduct(getUserData()?.token ?: "")
        return if (response.isSuccessful) {
            ViewState.Success(response.body() ?: Products.emptyProducts())
        } else {
            ViewState.Error(response.code(), response.message())
        }
    }

}