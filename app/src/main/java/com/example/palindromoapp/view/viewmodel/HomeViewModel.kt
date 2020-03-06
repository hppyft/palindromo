package com.example.palindromoapp.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.palindromoapp.view.model.Word
import com.example.palindromoapp.view.repository.WordRepository
import com.example.palindromoapp.view.util.ClearHistoricoListener
import com.example.palindromoapp.view.util.PalindromoUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class HomeViewModel : ViewModel(), ClearHistoricoListener {
    companion object {
        const val TIMER_DELAY = 1000L
    }

    val mWord: MutableLiveData<Word> by lazy { MutableLiveData<Word>() }
    val mWordList: MutableLiveData<List<Word>> by lazy { MutableLiveData<List<Word>>() }

    val mTimer by lazy { Timer() }
    var mTimerTask: TimerTask? = null

    init {
        viewModelScope.launch {
            mWordList.postValue(getAllWords())
        }
    }

    fun getWord(): LiveData<Word> {
        return mWord
    }

    fun getWordList(): LiveData<List<Word>> {
        return mWordList
    }

    override fun onClearHistoricoClicked() {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                WordRepository.deleteAll()
            }
            mWordList.postValue(getAllWords())
        }

    }

    fun onPalindromoTextChanged(text: String) {
        if (mTimerTask != null) mTimerTask!!.cancel()
        mTimer.purge()
        mTimerTask =
            object : TimerTask() {
                override fun run() {
                    onPalindromoTextStoppedChanging(text)
                }
            }
        mTimer.schedule(mTimerTask, TIMER_DELAY)
    }

    private fun onPalindromoTextStoppedChanging(text: String) {
        val isPalindromo = PalindromoUtil.isTextPalindromo(text)
        val word = Word(text = text, isPalindromo = isPalindromo)
        if (word.text.isNotEmpty()) insertWordAndUpdate(word)
        mWord.postValue(word)
    }

    private fun insertWordAndUpdate(word: Word) {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                WordRepository.insert(word)
            }
            mWordList.postValue(getAllWords())
        }
    }

    private suspend fun getAllWords(): List<Word> {
        return withContext(Dispatchers.Default) {
            WordRepository.getAll()
        }
    }
}