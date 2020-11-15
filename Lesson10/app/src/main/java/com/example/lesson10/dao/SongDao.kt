package com.example.lesson10.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lesson10.model.Song

@Dao
interface SongDao {

    @Query("SELECT * FROM song")
    fun getAll(): List<Song>

    @Insert
    fun insert(song: Song): Long

    @Query("DELETE FROM song WHERE 1=1")
    fun deleteAll()

}