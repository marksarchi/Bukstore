package com.sarchimarcus.bukstore.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.sarchimarcus.bukstore.R
import com.sarchimarcus.bukstore.databinding.FragmentDetailBinding

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentDetailBinding.inflate(inflater)
        binding.setLifecycleOwner(this)
        val item  = DetailFragmentArgs.fromBundle(requireArguments()).item
        val viewModelFactory = DetailViewModelFactory(item)
        binding.viewmodel = ViewModelProvider(this ,viewModelFactory).get(DetailViewModel::class.java)
        return binding.root
    }

}
