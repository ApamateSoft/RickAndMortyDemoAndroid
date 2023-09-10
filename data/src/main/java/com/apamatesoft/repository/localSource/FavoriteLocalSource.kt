package com.apamatesoft.repository.localSource

interface FavoriteLocalSource {

    suspend fun addFavorite(favorite: Int)

    suspend fun removeFavorite(favorite: Int)

    suspend fun loadFavorites(): List<Int>

}