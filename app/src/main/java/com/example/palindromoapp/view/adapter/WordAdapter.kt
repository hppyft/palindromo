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

    fun setList(words: List<Word>) {
        if (mList.isEmpty()) {
            mList = words
            notifyDataSetChanged()
        } else {
            mList = words
            notifyItemInserted(mList.size - 1)
        }
    }

    class WordViewHolder(val mBinding: WordItemBinding) : RecyclerView.ViewHolder(mBinding.root)
}