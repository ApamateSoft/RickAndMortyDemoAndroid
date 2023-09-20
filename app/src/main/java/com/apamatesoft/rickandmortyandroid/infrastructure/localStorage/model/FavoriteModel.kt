package com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("favorites")
data class FavoriteModel(
    @PrimaryKey val id: Int
)
