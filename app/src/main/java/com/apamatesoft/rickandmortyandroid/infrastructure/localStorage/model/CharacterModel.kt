package com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("characters")
data class CharacterModel(
    @PrimaryKey val id: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val imageUrl: String
)
