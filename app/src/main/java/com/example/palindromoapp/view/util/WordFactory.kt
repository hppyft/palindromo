package com.example.palindromoapp.view.util

import com.example.palindromoapp.view.model.Word

object WordFactory {

    fun createWord(text: String, isPalindromo: Boolean): Word {
        return Word(text = text, isPalindromo = isPalindromo)
    }
}