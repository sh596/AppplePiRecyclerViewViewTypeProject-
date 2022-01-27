package com.example.recyclerviewproject

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewproject.databinding.ItemMemoBinding
import com.example.recyclerviewproject.databinding.ItemMemoOnlyTitleBinding
import com.example.recyclerviewproject.model.Item
import com.example.recyclerviewproject.model.MemoItem
import com.example.recyclerviewproject.model.OnlyTitleItem

class BaseListAdapter() : ListAdapter<Item, RecyclerView.ViewHolder>(
    object : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

    }){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            MemoItem::class.hashCode() -> {
                val binding = ItemMemoBinding.inflate(LayoutInflater.from(parent.context))
                MemoViewHolder(binding)
            }
            OnlyTitleItem::class.hashCode() ->{
                val binding = ItemMemoOnlyTitleBinding.inflate(LayoutInflater.from(parent.context))
                OnlyTitleViewHolder(binding)
            }
            else -> {
                val binding = ItemMemoBinding.inflate(LayoutInflater.from(parent.context))
                MemoViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder){
            is MemoViewHolder -> holder.bind(getItem(position) as MemoItem)
            is OnlyTitleViewHolder -> holder.bind(getItem(position) as OnlyTitleItem)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).viewType
    }

    class MemoViewHolder(private val binding: ItemMemoBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: MemoItem){
            binding.title.text = item.title
            binding.description.text = item.description
        }
    }
    class OnlyTitleViewHolder(private val binding: ItemMemoOnlyTitleBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: OnlyTitleItem){
            binding.title.text = item.title
        }
    }
}
