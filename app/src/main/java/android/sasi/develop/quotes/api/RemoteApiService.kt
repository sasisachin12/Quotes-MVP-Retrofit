package android.sasi.develop.quotes.api

import android.sasi.develop.quotes.model.ResponseData
import retrofit2.Call
import retrofit2.http.GET

interface RemoteApiService {


    @GET("/quotes")
    fun getQuotes():Call<List<ResponseData>>
}