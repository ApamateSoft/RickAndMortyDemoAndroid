package com.apamatesoft.repository

import com.apamatesoft.repository.localSource.FavoriteLocalSource

class FavoriteRepository(
    private val localSource: FavoriteLocalSource
) {

    suspend fun addFavorite(favorite: Int) = localSource.addFavorite(favorite)

    suspend fun removeFavorite(favorite: Int) = localSource.removeFavorite(favorite)

    suspend fun loadFavorites(): List<Int> = localSource.loadFavorites()

}