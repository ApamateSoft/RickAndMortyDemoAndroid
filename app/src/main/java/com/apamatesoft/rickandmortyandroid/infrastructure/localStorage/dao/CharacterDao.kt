package com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.entity.CharacterEntity

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(character: CharacterEntity)

    @Query("SELECT * FROM characters")
    fun getAll(): List<CharacterEntity>

}