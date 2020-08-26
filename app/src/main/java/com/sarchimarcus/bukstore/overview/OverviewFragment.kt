package com.sarchimarcus.bukstore.overview

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sarchimarcus.bukstore.BooksAdapter
import com.sarchimarcus.bukstore.databinding.FragmentOverviewBinding
import com.sarchimarcus.bukstore.models.Item
import com.sarchimarcus.bukstore.network.BookRepository

/**
 * A simple [Fragment] subclass.
 */
class OverviewFragment : Fragment() {
    lateinit var editText :EditText
    val bookRepository  = BookRepository()

    val factory = OverviewViewModelFactory(bookRepository)
    val viewModel :OverviewViewModel by lazy { ViewModelProvider(this,factory).get(OverviewViewModel::class.java) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)
        binding.setLifecycleOwner (this)
        binding.recyclerView.adapter = BooksAdapter(BooksAdapter.OnClickListener{
            viewModel.displayBookDetails(it)

        })

        viewModel.navigateToSelectedBook.observe(viewLifecycleOwner, Observer {
            if(it != null){
                this.findNavController().navigate(OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(it))
                viewModel.displayBookDetailsComplete()
            }
        })


        editText = binding.search
        binding.viewModel = viewModel

        var searchButton:Button = binding.btnSearch



        searchButton.setOnClickListener {
            searchBook(editText.text.toString())
        }


        // Inflate the layout for this fragment
        return binding.root
    }
    fun searchBook(searchText:String){
        Log.e("OverviewFragment", searchText)
        viewModel.getBookRepository(searchText)

    }



}
