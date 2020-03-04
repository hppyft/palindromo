package com.example.palindromoapp.view.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = DatabaseTables.WordTable.NAME)
data class Word(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = DatabaseTables.WordTable.COLUMN_ID) var id: Long? = null,
    @ColumnInfo(name = DatabaseTables.WordTable.COLUMN_TEXT) val text: String,
    @ColumnInfo(name = DatabaseTables.WordTable.COLUMN_IS_PALINDROMO) val isPalindromo: Boolean
)