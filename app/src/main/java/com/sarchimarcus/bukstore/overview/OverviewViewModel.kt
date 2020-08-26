package com.sarchimarcus.bukstore.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sarchimarcus.bukstore.models.Item
import com.sarchimarcus.bukstore.models.Volumes
import com.sarchimarcus.bukstore.network.BookRepository

class OverviewViewModel(bookRepository: BookRepository) :ViewModel(){


    private val bookRepo = bookRepository
   //  var searchTxt  = String()

    private val _booksList = MutableLiveData<Volumes>()
      val booksList:LiveData<Volumes>
        get() {
            return  _booksList
        }


     fun getBookRepository(searchText:String){
    Log.e("OverviewViewModel :",searchText)
       var result =  bookRepo.getBooks(searchText)
        _booksList.value = result.value
    }
    private val _navigateToSelectedBook = MutableLiveData<Item>()

    // The external immutable LiveData for the navigation property
    val navigateToSelectedBook: LiveData<Item>
        get() = _navigateToSelectedBook


    fun displayBookDetails(item: Item) {
        _navigateToSelectedBook.value = item
    }

    fun displayBookDetailsComplete() {
        _navigateToSelectedBook.value = null
    }

    enum class BookStatus{ LOADING,ERROR,DONE}

    private val _status = MutableLiveData<BookStatus>()
    val status: LiveData<BookStatus>
        get() = _status
}