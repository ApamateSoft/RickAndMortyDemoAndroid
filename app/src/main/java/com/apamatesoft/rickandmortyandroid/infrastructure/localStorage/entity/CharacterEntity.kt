package com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("characters")
data class CharacterEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val imageUrl: String
)
