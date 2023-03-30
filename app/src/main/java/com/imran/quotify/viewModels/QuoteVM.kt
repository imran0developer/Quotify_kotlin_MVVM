package com.imran.quotify.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.imran.quotify.models.Quote

class QuoteVM(val context: Context) : ViewModel(){
    private var quoteList : Array<Quote> = emptyArray()

    private var index : Int = 0

    init {
        quoteList = loadQuotesFromAssets()
    }

    private fun loadQuotesFromAssets(): Array<Quote> {

        val inputStream = context.assets.open("quotes.json")
        val fileSize = inputStream.available()
        val buffer = ByteArray(fileSize)
        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        quoteList = gson.fromJson(json,Array<Quote>::class.java)


        return quoteList
    }

    fun getQuote() = quoteList[index]
    fun nextQuote() =  quoteList[++index]
    fun prevQuote() = quoteList[--index]

    fun getQuoteList(): ArrayList<Quote> {
        return ArrayList(quoteList.toList())
    }

}