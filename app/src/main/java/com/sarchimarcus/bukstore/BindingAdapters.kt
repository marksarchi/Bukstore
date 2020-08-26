package com.sarchimarcus.bukstore

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sarchimarcus.bukstore.models.Book
import com.sarchimarcus.bukstore.models.Item
import com.sarchimarcus.bukstore.overview.OverviewViewModel

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,data:List<Item>?){
    val adapter = recyclerView.adapter as BooksAdapter
    adapter.submitList(data)
}
@BindingAdapter("imgUrl")
fun bindImage(imgView:ImageView,imgUrl:String?){
    imgUrl?.let {
        //val imgUri = imgUrl.toUri().buildUpon().build()
        Glide.with(imgView.context)
            .load(imgUrl)
            .apply(RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imgView)
    }

}
@BindingAdapter("text")
fun bindText(textView: TextView,text:String?){
    textView.text = text
}

@BindingAdapter("status")
fun bindStatus(statusImageView:ImageView,status :OverviewViewModel.BookStatus){

}

