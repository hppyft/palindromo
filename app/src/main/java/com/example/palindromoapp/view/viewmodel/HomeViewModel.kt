package com.example.palindromoapp.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.palindromoapp.view.PalindromoUtil
import java.util.*

class HomeViewModel : ViewModel() {
    companion object {
        const val TIMER_DELAY = 1000L
    }

    val mIsTextPalindromo: MutableLiveData<Boolean?> by lazy { MutableLiveData<Boolean?>() }
    val mTimer by lazy { Timer() }
    var mTimerTask: TimerTask? = null


    fun getIsTextPalindromo(): LiveData<Boolean?> {
        return mIsTextPalindromo
    }

    fun onPalindromoTextChanged(text: String) {
        if (mTimerTask != null) mTimerTask!!.cancel()
        mTimer.purge()
        mTimerTask =
            object : TimerTask() {
                override fun run() {
                    mIsTextPalindromo.postValue(PalindromoUtil.isTextPalindromo(text))
                }
            }
        mTimer.schedule(mTimerTask, TIMER_DELAY)
    }
}