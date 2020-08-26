package com.sarchimarcus.bukstore.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sarchimarcus.bukstore.models.Item

class DetailViewModel (item:Item) :ViewModel(){
    private val _selectedBook = MutableLiveData<Item>()

    // The external LiveData for the SelectedProperty
    val selectedBook: LiveData<Item>
        get() = _selectedBook

    init {
        _selectedBook.value = item
    }
}