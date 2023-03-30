package com.imran.quotify.viewModelFactories

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.imran.quotify.viewModels.QuoteVM

class QuoteVMFactory(val context: Context) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuoteVM(context) as T
    }
}