package com.imran.quotify.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.imran.quotify.R
import com.imran.quotify.models.Quote

class QuoteAdapter(val context: Context , val quoteList: ArrayList<Quote> ) : RecyclerView.Adapter<QuoteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     val view = LayoutInflater.from(context).inflate(R.layout.quote_rv_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return quoteList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = quoteList[position]
        holder.quoteTV.text = item.text
        holder.authorTV.text = item.author


    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val quoteTV: TextView = itemView.findViewById(R.id.quote)
        val authorTV: TextView = itemView.findViewById(R.id.author)
    }
}