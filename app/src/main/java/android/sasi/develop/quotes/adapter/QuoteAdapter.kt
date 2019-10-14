package android.sasi.develop.quotes.adapter

import android.sasi.develop.quotes.R
import android.sasi.develop.quotes.model.ResponseData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.quotes_item.*


class QuoteAdapter(private val data: List<ResponseData>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.quotes_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(data[position])
    }

}


class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {


    fun bindItems(responseData: ResponseData) {

        quote_name.text = responseData.en
        authur.text = responseData.author
    }
}