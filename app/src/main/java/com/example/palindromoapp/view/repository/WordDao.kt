package com.example.palindromoapp.view.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.palindromoapp.view.model.DatabaseTables
import com.example.palindromoapp.view.model.Word

@Dao
interface WordDao {
    @Query("""SELECT * FROM ${DatabaseTables.WordTable.NAME}""")
    fun getAll(): List<Word>

    @Insert
    fun insertAll(vararg words: Word)

    @Query("""DELETE FROM ${DatabaseTables.WordTable.NAME}""")
    fun deleteAll()

    @Delete
    fun delete(vararg words: Word)
}