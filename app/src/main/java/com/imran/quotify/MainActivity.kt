package com.imran.quotify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.imran.quotify.adapters.QuoteAdapter
import com.imran.quotify.models.Quote
import com.imran.quotify.viewModelFactories.QuoteVMFactory
import com.imran.quotify.viewModels.QuoteVM

class MainActivity : AppCompatActivity() {

    private lateinit var quoteVM: QuoteVM
    private lateinit var quoteAdapter: QuoteAdapter


    private val quoteTv : TextView
        get() = findViewById(R.id.quote)

    private val authorTv : TextView
        get() = findViewById(R.id.author)
    private val quoteRv : RecyclerView
        get() = findViewById(R.id.quote_rv)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quoteVM = ViewModelProvider(this,QuoteVMFactory(application)).get(QuoteVM::class.java)


        //i have implemented recyclerview to show all quotes at time
        quoteRv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        quoteAdapter = QuoteAdapter(application,quoteVM.getQuoteList())
        quoteRv.adapter = quoteAdapter



//        setQuote(quoteVM.getQuote())

    }

    fun setQuote(quote: Quote) {
        //this is for setting one quote at a time
        quoteTv.text = quote.text
        authorTv.text = quote.author


    }

    fun shareQuote(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT,quoteVM.getQuote().text)
        startActivity(intent)


    }
    fun nextQuote(view: View) {
        setQuote(quoteVM.nextQuote())
    }
    fun prevQuote(view: View) {
        setQuote(quoteVM.prevQuote())
    }
}