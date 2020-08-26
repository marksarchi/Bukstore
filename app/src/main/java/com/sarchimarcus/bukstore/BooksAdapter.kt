package com.sarchimarcus.bukstore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sarchimarcus.bukstore.databinding.ListItemsBinding
import com.sarchimarcus.bukstore.models.Item

class BooksAdapter(val onClickListener:OnClickListener):ListAdapter<Item,BooksAdapter.ViewHolder>(DiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        return ViewHolder(ListItemsBinding.inflate(LayoutInflater.from(parent.context)))
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

       val item   = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(item)
        }
        holder.bind(item)



    }

    class ViewHolder (var binding:ListItemsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item){
            binding.item = item
            binding.executePendingBindings()
        }

    }

    companion object DiffCallback : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class OnClickListener(val clickListener: (item:Item)->Unit) {
        fun onClick(item: Item) = clickListener(item)

    }
}




/*
class BooksAdapter:RecyclerView.Adapter<BooksAdapter.ViewHolder>() {
    private val context: Context? = null

    var data = listOf<Item>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.list_items, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  data.size
    }

    override fun onBindViewHolder(holder: BooksAdapter.ViewHolder, position: Int) {

        val item  = data[position]
        holder.titleTv.text = item.book.title



        val author = item.book.author
        if(author!=null  ){
            holder.authorsTv.text = item.book.author[0]
        }

        val imageUrl = item.book.imageLinks.getThumbnail()

        Glide.with(holder.itemView.context)
            .load(imageUrl)
            .into(holder.imageView)



    }

    class ViewHolder (itemView:View): RecyclerView.ViewHolder(itemView) {
        val titleTv: TextView = itemView.findViewById(R.id.textViewtitle)
        val authorsTv: TextView = itemView.findViewById(R.id.textViewAuthor)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val cardView: CardView = itemView.findViewById(R.id.list_item)

    }
}
*/