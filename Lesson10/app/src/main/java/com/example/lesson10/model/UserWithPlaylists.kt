package com.example.lesson10.model

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithPlaylists(
    @Embedded val user: User,
    @Relation(
        parentColumn = "uid",
        entityColumn = "userCreaterId"
    )
    val playlists: List<Playlist>
)