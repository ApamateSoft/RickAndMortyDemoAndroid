package com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.entity.FavoriteEntity

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(favoriteEntity: FavoriteEntity)

    @Query("SELECT * FROM favorites")
    fun getAll(): List<FavoriteEntity>

    @Delete
    fun delete(favoriteEntity: FavoriteEntity)

}