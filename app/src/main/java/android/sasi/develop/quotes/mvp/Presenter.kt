package android.sasi.develop.quotes.mvp

import android.sasi.develop.quotes.api.RetrofitBuilder
import android.sasi.develop.quotes.model.ResponseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Presenter(val view: Contract.View) : Contract.Presenter {


    private val retrofit = RetrofitBuilder.getRemoteApiService()


    override fun getQuotes() {
        view.showLoader()
        retrofit.getQuotes().enqueue(object : Callback<List<ResponseData>> {
            override fun onFailure(call: Call<List<ResponseData>>, t: Throwable) {
                view.hideLoader()
            }

            override fun onResponse(
                call: Call<List<ResponseData>>,
                response: Response<List<ResponseData>>
            ) {
                view.hideLoader()
                response.body()?.let { view.dataResults(it) }

            }
        })
    }
}