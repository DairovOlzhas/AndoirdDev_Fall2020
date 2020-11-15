package com.example.lesson10

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lesson10.dao.*
import com.example.lesson10.model.*

@Database(
    entities = arrayOf(
        User::class,
        Library::class,
        Playlist::class,
        Song::class,
        PlaylistSongCrossRef::class
    ), version = 7
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun UserDao(): UserDao
    abstract fun LibraryDao(): LibraryDao
    abstract fun PlaylistDao(): PlaylistDao
    abstract fun SongDao(): SongDao
    abstract fun PlaylistSongCrossRefDao(): PlaylistSongCrossRefDao
}