package com.apamatesoft.rickandmortyandroid.infrastructure.localStorage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.CharacterDao
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.FavoriteDao
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.model.CharacterModel
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.model.FavoriteModel

@Database(entities = [CharacterModel::class, FavoriteModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getCharacterDao(): CharacterDao

    abstract fun getFavoriteDao(): FavoriteDao

}