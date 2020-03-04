package com.example.palindromoapp.view.model

object DatabaseTables {

    const val NAME = "PalindromoDb"

    object WordTable {
        const val NAME = "word_table"
        const val COLUMN_ID = "_id"
        const val COLUMN_TEXT = "text"
        const val COLUMN_IS_PALINDROMO = "is_palindromo"
    }
}