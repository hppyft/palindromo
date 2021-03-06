package com.example.palindromoapp.view.util

object PalindromoUtil {

    fun isTextPalindromo(text: String): Boolean {
        if (text.isEmpty()) return false
        val chars = text.split("")
        chars.forEachIndexed { index, char ->
            val reverseIndex = chars.size - 1 - index
            if (reverseIndex <= index) return true
            if (char != chars[reverseIndex]) return false
        }
        return false
    }
}