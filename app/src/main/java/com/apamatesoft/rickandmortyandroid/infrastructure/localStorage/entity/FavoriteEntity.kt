package com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("favorites")
data class FavoriteEntity(
    @PrimaryKey(autoGenerate = true) val id: Int
)
