package com.example.palindromoapp.view.util

object StringUtil {

    fun clearStringForPalindromo(text: String): String {
        return text.toLowerCase().replace("\\s".toRegex(), "")
    }
}