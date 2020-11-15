package com.example.lesson10.model

import androidx.room.Entity
import androidx.room.ForeignKey


@Entity(
    primaryKeys = ["playlistId", "songId"],
    foreignKeys = arrayOf(
        ForeignKey(
            entity = Song::class,
            parentColumns = arrayOf("songId"),
            childColumns = arrayOf("playlistId"),
        ),
        ForeignKey(
            entity = Playlist::class,
            parentColumns = arrayOf("playlistId"),
            childColumns = arrayOf("songId"),
        ),
    )
)
data class PlaylistSongCrossRef(
    var playlistId: Long,
    var songId: Long
)