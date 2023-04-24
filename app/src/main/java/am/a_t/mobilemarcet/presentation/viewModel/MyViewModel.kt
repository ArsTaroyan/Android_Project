package am.a_t.mobilemarcet.presentation.viewModel

import am.a_t.mobilemarcet.data.viewState.ViewState
import am.a_t.mobilemarcet.domain.iteractors.*
import am.a_t.mobilemarcet.model.Login
import am.a_t.mobilemarcet.model.ProductData
import am.a_t.mobilemarcet.model.Products
import am.a_t.mobilemarcet.model.UserData
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MyViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val loginUseCase: LoginUseCase,
    private val productsUseCase: ProductsUseCase,
    private val readUseCase: ReadUseCase,
    private val removeUseCase: RemoveUseCase
) : ViewModel() {

    val autoLoginLiveData = MutableSharedFlow<Boolean>()
    val samsungLiveData = MutableSharedFlow<List<ProductData>?>(1)
    val laptopsLiveData = MutableSharedFlow<List<ProductData>?>(1)
    val logOutLiveData = MutableSharedFlow<Boolean>()
    val userLiveData = MutableSharedFlow<UserData>()
    val localLiveData = MutableSharedFlow<UserData>(1)
    val errorLiveData = MutableSharedFlow<String>()

    init {
        viewModelScope.launch {
            autoLoginLiveData.emit(readUseCase.readUserLocalData())
            localLiveData.emit(getUserUseCase.getUserData() ?: UserData.emptyUserData())
        }
    }

    fun login(login: Login) {
        viewModelScope.launch {
            when (val response = loginUseCase.login(login)) {
                is ViewState.Success -> {
                    userLiveData.emit(response.data)
                }
                is ViewState.Error -> {
                    errorLiveData.emit(response.message)
                }
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            logOutLiveData.emit(removeUseCase.removeUserData())
        }
    }

    fun product() {
        val samsungList = mutableListOf<ProductData>()
        val laptopList = mutableListOf<ProductData>()
        viewModelScope.launch {
            when (val response = productsUseCase.product()) {
                is ViewState.Success -> {
                    for(i in response.data.products) {
                        if (i.category == "smartphones") {
                            samsungList.add(i)
                        }else if (i.category == "laptops") {
                            laptopList.add(i)
                        }
                    }

                    samsungLiveData.emit(samsungList)
                    laptopsLiveData.emit(laptopList)
                }
                is ViewState.Error -> {
                    errorLiveData.emit(response.message)
                }
            }
        }
    }

}