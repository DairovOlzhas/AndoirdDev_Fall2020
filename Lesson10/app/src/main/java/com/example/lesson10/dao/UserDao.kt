package com.example.lesson10.dao

import androidx.room.*
import com.example.lesson10.model.User
import com.example.lesson10.model.UserAndLibrary
import com.example.lesson10.model.UserWithPlaylists


@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getAll(): List<User>

    @Query("SELECT * FROM users WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Delete
    fun delete(user: User)

    @Update
    fun update(user: User)

    @Insert
    fun insert(user1: User): Long

    @Transaction
    @Query("SELECT * FROM users")
    fun getUsersAndLibraries(): List<UserAndLibrary>

    @Transaction
    @Query("SELECT * FROM users")
    fun getUsersWithPlaylists(): List<UserWithPlaylists>

    @Query("DELETE FROM users WHERE 1=1")
    fun deleteAll()

}