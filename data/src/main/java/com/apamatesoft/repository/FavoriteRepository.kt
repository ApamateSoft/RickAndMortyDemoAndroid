package com.apamatesoft.repository

import com.apamatesoft.repository.localSource.FavoriteLocalSource

class FavoriteRepository(
    private val localSource: FavoriteLocalSource
) {

    suspend fun saveFavorites(favorites: List<Int>) = localSource.saveFavorites(favorites)

    suspend fun loadFavorites(): List<Int> = localSource.loadFavorites()

}