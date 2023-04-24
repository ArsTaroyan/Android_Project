package am.a_t.mobilemarcet.di

import am.a_t.mobilemarcet.data.api.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {

    single<ApiService> {
        getRetrofit().create(ApiService::class.java)
    }

}

fun getRetrofit(): Retrofit {
    val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .addInterceptor { chain ->
            val request = chain.request()
            request.newBuilder().addHeader(
                "Content-Type",
                "application/json"
            ).build()

            chain.proceed(request)
        }.build()

    return Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}