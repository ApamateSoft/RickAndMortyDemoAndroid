package com.apamatesoft.rickandmortyandroid.infrastructure.localStorage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.CharacterDao
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.FavoriteDao
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.entity.CharacterEntity
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.entity.FavoriteEntity

@Database(entities = [CharacterEntity::class, FavoriteEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getCharacterDao(): CharacterDao

    abstract fun getFavoriteDao(): FavoriteDao

}