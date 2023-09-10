package com.apamatesoft.repository.localSource

interface FavoriteLocalSource {

    suspend fun saveFavorites(favorites: List<Int>)

    suspend fun loadFavorites(): List<Int>

}