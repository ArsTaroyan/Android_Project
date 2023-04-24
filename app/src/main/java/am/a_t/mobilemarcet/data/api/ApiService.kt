package am.a_t.mobilemarcet.data.api

import am.a_t.mobilemarcet.model.Login
import am.a_t.mobilemarcet.model.Products
import am.a_t.mobilemarcet.model.UserData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @POST("auth/login")
    suspend fun auth(@Body login: Login): Response<UserData>

    @GET("auth/products")
    suspend fun getProduct(@Header("Authorization") token: String): Response<Products>

}