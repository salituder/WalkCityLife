package com.example.wclchat.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [TrackItem :: class], version = 1)
abstract class MainDb : RoomDatabase() {
    abstract fun getDao(): Dao
    companion object {
        @Volatile
        private var INSTANCE: MainDb? = null
        fun getDatabase(context: Context): MainDb {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDb::class.java,
                    "GPSTracker.db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}