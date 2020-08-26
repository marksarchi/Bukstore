package com.sarchimarcus.bukstore.overview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sarchimarcus.bukstore.detail.DetailViewModel
import com.sarchimarcus.bukstore.network.BookRepository

class OverviewViewModelFactory(private val bookRepository: BookRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(OverviewViewModel::class.java)){
            return OverviewViewModel(bookRepository) as T
        }
       throw IllegalArgumentException("Unknown viewmodel")
    }
}