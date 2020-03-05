package com.example.palindromoapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.palindromoapp.databinding.WordItemBinding
import com.example.palindromoapp.view.model.Word

class WordAdapter(var mList: List<Word> = listOf()) :
    RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val binding = WordItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WordViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val item = mList.get(position)
        holder.mBinding.word = item
    }

    fun updateList(words: List<Word>) {
        val oldList = mList
        mList = words
        if (mList.size > oldList.size && oldList.isNotEmpty()) {
            notifyItemInserted(mList.size - 1)
        } else {
            notifyDataSetChanged()
        }
    }

    class WordViewHolder(val mBinding: WordItemBinding) : RecyclerView.ViewHolder(mBinding.root)
}