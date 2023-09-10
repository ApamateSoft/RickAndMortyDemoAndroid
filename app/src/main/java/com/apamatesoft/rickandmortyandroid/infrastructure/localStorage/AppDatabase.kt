package com.apamatesoft.rickandmortyandroid.infrastructure.localStorage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.CharacterDao
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.entity.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getCharacterDao(): CharacterDao
}