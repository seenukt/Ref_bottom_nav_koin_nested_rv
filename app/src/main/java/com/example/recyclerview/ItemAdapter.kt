package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.InnerItemBinding

class ItemAdapter(private val innerClick:(String)->Unit ):androidx.recyclerview.widget.ListAdapter<String,ItemAdapter.ItemHolder>(DiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ItemHolder {
          return ItemHolder(InnerItemBinding.inflate(LayoutInflater.from(parent.context),parent,false),innerClick)
    }

    override fun onBindViewHolder(holder:ItemHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ItemHolder(private val binding: InnerItemBinding, val innerClick: (data:String) -> Unit): RecyclerView.ViewHolder(binding.root){
         private var data :String? = null
        init {
            binding.root.setOnClickListener { data?.let{innerClick(it)} }
        }

        fun  bind(d :String){
            data = d
            binding.data.text = d
        }
    }

    private class DiffUtils :DiffUtil.ItemCallback<String>(){
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
           return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem:String): Boolean {
            return oldItem == newItem
        }

    }
}