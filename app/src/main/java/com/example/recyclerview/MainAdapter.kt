package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.recyclerview.databinding.ItemViewBinding

data class MainData(val month: String , val details :  List<String>)

class MainAdapter(private val mainClick:(mainData : String)->Unit, val innerClick : (innerData : String)->Unit): ListAdapter<MainData,MainAdapter.MainHolder>(DiffUtils()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {

      return MainHolder(ItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false), mainClick, innerClick)

    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MainHolder(
        private val itemBinding: ItemViewBinding,
        val mainClick: (mainData: String) -> Unit,
        val innerClick: (innerData: String) -> Unit
    ): RecyclerView.ViewHolder(itemBinding.root) {

        init {
            itemBinding.root.setOnClickListener{
                mainClick(itemBinding.tvMonth.text.toString())
            }
        }
        fun bind(item : MainData){
            val adapter = ItemAdapter {
                innerClick(it)
            }
            itemBinding.tvMonth.text = item.month
            itemBinding.innerRv.adapter = adapter
            itemBinding.innerRv.layoutManager = LinearLayoutManager(itemBinding.root.context,VERTICAL,false)
            adapter.submitList(item.details)
        }


    }


     class DiffUtils:DiffUtil.ItemCallback<MainData>(){
         override fun areItemsTheSame(oldItem: MainData, newItem: MainData): Boolean {
             return oldItem == newItem
         }

         override fun areContentsTheSame(oldItem: MainData, newItem: MainData): Boolean {
             return oldItem.month == newItem.month
         }

     }

}