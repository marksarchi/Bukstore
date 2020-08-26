package com.sarchimarcus.bukstore.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sarchimarcus.bukstore.models.Item

class DetailViewModelFactory(private val item: Item) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(item) as T
        }
        throw  IllegalArgumentException("Unknown view model")
    }
}