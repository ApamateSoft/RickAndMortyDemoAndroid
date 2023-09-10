package com.apamatesoft.usecase

import com.apamatesoft.repository.FavoriteRepository

class AddFavoriteCase(
    private val favoriteRepository: FavoriteRepository
) {

    suspend fun invoke(favorite: Int) {
        try {
            return favoriteRepository.addFavorite(favorite)
        } catch (_: Exception) { }
    }

}