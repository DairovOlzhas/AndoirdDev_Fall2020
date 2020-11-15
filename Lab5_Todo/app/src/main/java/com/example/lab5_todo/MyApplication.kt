package com.example.lab5_todo

import android.app.Application
import androidx.room.Room

class MyApplication: Application() {
    private var database: AppDatabase? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, AppDatabase::class.java, "lab5_db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    fun getDatabase(): AppDatabase? {
        return database
    }

    companion object {
        lateinit var instance: MyApplication
    }
}