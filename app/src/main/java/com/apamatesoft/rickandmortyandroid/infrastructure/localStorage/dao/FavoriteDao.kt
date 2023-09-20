package com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.model.FavoriteModel

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(favoriteModel: FavoriteModel)

    @Query("SELECT * FROM favorites")
    fun getAll(): List<FavoriteModel>

    @Delete
    fun delete(favoriteModel: FavoriteModel)

}