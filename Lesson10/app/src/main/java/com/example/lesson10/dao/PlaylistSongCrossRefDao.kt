package com.example.lesson10.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lesson10.model.PlaylistSongCrossRef

@Dao
interface PlaylistSongCrossRefDao {
    @Insert
    fun insert(playlistSongCrossRef: PlaylistSongCrossRef): Long

    @Query("DELETE FROM playlistsongcrossref WHERE 1=1")
    fun deleteAll()

}