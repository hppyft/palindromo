package com.example.palindromoapp.view.view

import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.palindromoapp.R
import com.example.palindromoapp.databinding.HomeActivityBinding
import com.example.palindromoapp.view.adapter.WordAdapter
import com.example.palindromoapp.view.model.Word
import com.example.palindromoapp.view.util.AfterTextChangedListener
import com.example.palindromoapp.view.util.StringUtil
import com.example.palindromoapp.view.viewmodel.HomeViewModel

class HomeActivity : AppCompatActivity() {

    lateinit var mBinding: HomeActivityBinding
    val mViewModel: HomeViewModel by lazy { ViewModelProvider(this).get(HomeViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        mBinding = DataBindingUtil.setContentView(
            this,
            R.layout.home_activity
        )

        mBinding.clearHistoricoListener = mViewModel

        setupOnTextChanged()

        val adapter = WordAdapter()
        mBinding.wordsList.adapter = adapter

        mViewModel.getWordList().observe(this, Observer<List<Word>> {
            changeListVisibility(it)
            adapter.updateList(it)
        })

        mViewModel.getWord().observe(this, Observer {
            setAnswer(it)
        })
    }

    private fun setupOnTextChanged() {
        mBinding.homePalindromoEt.addTextChangedListener(object :
            AfterTextChangedListener {
            override fun afterTextChanged(s: Editable?) {
                mBinding.homeResposta.visibility = View.GONE
                mBinding.homeProgressbar.visibility = View.VISIBLE
                mViewModel.onPalindromoTextChanged(StringUtil.clearStringForPalindromo(s.toString()))
            }
        })
    }

    private fun changeListVisibility(list: List<Word>) {
        if (list.isNotEmpty()) mBinding.wordListGroup.visibility =
            View.VISIBLE else mBinding.wordListGroup.visibility = View.GONE
    }

    private fun setAnswer(it: Word) {
        mBinding.homeProgressbar.visibility = View.GONE
        if (it.text.isNotEmpty()) {
            when (it.isPalindromo) {
                true -> mBinding.homeResposta.text =
                    getString(R.string.success_answer, it.text)
                false -> mBinding.homeResposta.text =
                    getString(R.string.failure_answer, it.text)
            }
            mBinding.homeResposta.visibility = View.VISIBLE
        }
    }
}
