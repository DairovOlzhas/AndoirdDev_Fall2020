package com.example.lesson10.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lesson10.model.Library

@Dao
interface LibraryDao {
    @Insert
    fun insert(library: Library): Long

    @Query("DELETE FROM library WHERE 1=1")
    fun deleteAll()
}