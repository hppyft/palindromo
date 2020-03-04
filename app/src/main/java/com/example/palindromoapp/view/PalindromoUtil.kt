package com.example.palindromoapp.view

object PalindromoUtil {

    fun isTextPalindromo(text: String): Boolean? {
        if (text.isEmpty()) return null
        val chars = text.split("")
        chars.forEachIndexed { index, char ->
            val reverseIndex = chars.size - 1 - index
            if (reverseIndex <= index) return true
            if (char != chars[reverseIndex]) return false
        }
        return null
    }
}