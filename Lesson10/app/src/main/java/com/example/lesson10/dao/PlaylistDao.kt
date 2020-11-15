package com.example.lesson10.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lesson10.model.Playlist
import com.example.lesson10.model.PlaylistWithSongs
import com.example.lesson10.model.Song
import com.example.lesson10.model.User


@Dao
interface PlaylistDao {
    @Insert
    fun insert(playlist: Playlist): Long

    @Query("SELECT * FROM playlist")
    fun getPlaylistsWithSongs(): List<PlaylistWithSongs>

    @Query("SELECT * FROM playlist WHERE playlistId = (:userId)")
    fun getAll(userId: Long): List<Playlist>

    @Query("DELETE FROM playlist WHERE 1=1")
    fun deleteAll()

}