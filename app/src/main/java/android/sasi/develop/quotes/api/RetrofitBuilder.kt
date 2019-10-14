package android.sasi.develop.quotes.api

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit


object RetrofitBuilder {

    private const val baseURl = "https://programming-quotes-api.herokuapp.com"


    fun getRemoteApiService(): RemoteApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(RemoteApiService::class.java)
    }

}