package com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.model.CharacterModel

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(character: CharacterModel)

    @Query("SELECT * FROM characters")
    fun getAll(): List<CharacterModel>

}