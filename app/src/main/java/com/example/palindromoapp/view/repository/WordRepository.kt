package com.example.palindromoapp.view.repository

import androidx.room.Room
import com.example.palindromoapp.view.PalindromoApplication
import com.example.palindromoapp.view.model.DatabaseTables
import com.example.palindromoapp.view.model.Word

object WordRepository {

    val database: AppDatabase by lazy {
        Room.databaseBuilder(
            PalindromoApplication.instance,
            AppDatabase::class.java,
            DatabaseTables.NAME
        ).build()
    }

    fun getAll(): List<Word> {
        return database.wordDao().getAll()
    }

    fun insert(vararg words: Word) {
        database.wordDao().insertAll(*words)
    }
}