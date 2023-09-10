package com.apamatesoft.rickandmortyandroid.infrastructure.repository.faviorite

import com.apamatesoft.repository.localSource.FavoriteLocalSource
import javax.inject.Inject

class FavoriteLocalSourceImp @Inject constructor(): FavoriteLocalSource {

    private var favorites: List<Int> = emptyList()

    override suspend fun addFavorite(favorite: Int) {
        favorites += favorite
    }

    override suspend fun removeFavorite(favorite: Int) {
        favorites = favorites.filter { it != favorite }
        println(">>: FavoriteLocalSourceImp.removeFavorite: { favorite: $favorite, favorites: $favorites }")
    }

    override suspend fun loadFavorites(): List<Int> {
        println(">>: FavoriteLocalSourceImp.loadFavorites: $favorites")
        return favorites
    }

}