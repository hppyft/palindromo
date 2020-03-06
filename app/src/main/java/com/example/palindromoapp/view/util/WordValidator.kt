package com.example.palindromoapp.view.util

import com.example.palindromoapp.view.model.Word

object WordValidator {

    fun isValid(word: Word): Boolean {
        return word.text.isNotEmpty()
    }
}