package com.example.palindromoapp.view

import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.palindromoapp.R
import com.example.palindromoapp.databinding.HomeActivityBinding
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

        setupOnTextChanged()

        mViewModel.getIsTextPalindromo().observe(this, Observer {
            setAnswer(it)
        })
    }

    private fun setupOnTextChanged() {
        mBinding.homePalindromoEt.addTextChangedListener(object : AfterTextChangedListener {
            override fun afterTextChanged(s: Editable?) {
                mBinding.homeResposta.visibility = View.GONE
                mBinding.homeProgressbar.visibility = View.VISIBLE
                mViewModel.onPalindromoTextChanged(s.toString())
            }
        })
    }

    private fun setAnswer(it: Boolean?) {
        mBinding.homeProgressbar.visibility = View.GONE
        if (it != null) {
            when (it) {
                true -> mBinding.homeResposta.text =
                    getString(R.string.success_answer, mBinding.homePalindromoEt.text.toString())
                false -> mBinding.homeResposta.text =
                    getString(R.string.failure_answer, mBinding.homePalindromoEt.text.toString())
            }
            mBinding.homeResposta.visibility = View.VISIBLE
        }
    }
}
