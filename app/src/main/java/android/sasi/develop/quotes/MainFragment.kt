package android.sasi.develop.quotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.sasi.develop.quotes.adapter.QuoteAdapter
import android.sasi.develop.quotes.model.ResponseData
import android.sasi.develop.quotes.mvp.Contract
import android.sasi.develop.quotes.mvp.Presenter
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment(), Contract.View {


    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var presenter: Presenter
    private lateinit var quoteAdapter: QuoteAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter = Presenter(this)
        presenter.getQuotes()

    }

    fun setAdapter(data: List<ResponseData>) {
        quoteAdapter = QuoteAdapter(data)
        recycler_view.layoutManager = LinearLayoutManager(activity)
        recycler_view.adapter = quoteAdapter
    }

    override fun showLoader() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        progressBar.visibility = View.GONE
    }

    override fun dataResults(data: List<ResponseData>) {
        Log.e("*** ", "Response list count" + data.size)
        setAdapter(data)
    }
}
