package android.sasi.develop.quotes.mvp

import android.sasi.develop.quotes.model.ResponseData

interface Contract {

    interface View {
        fun showLoader()
        fun hideLoader()
        fun dataResults(data: List<ResponseData>)
    }


    interface Presenter {
        fun getQuotes()
    }

}