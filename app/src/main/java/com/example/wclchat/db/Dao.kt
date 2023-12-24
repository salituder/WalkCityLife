package com.example.wclchat.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
@Dao
interface Dao {
    @Insert
    suspend fun insertTrack(track: TrackItem): Long

    @Query("SELECT * FROM track")
    fun getAllTracks(): Flow<List<TrackItem>>

    @Delete
    suspend fun deleteTrack(trackItem: TrackItem): Int
}
