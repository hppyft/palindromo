package com.example.palindromoapp.view.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.palindromoapp.view.model.Word

@Database(entities = arrayOf(Word::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao
}