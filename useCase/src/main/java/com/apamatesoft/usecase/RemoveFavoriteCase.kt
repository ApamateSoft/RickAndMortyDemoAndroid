package com.apamatesoft.usecase

import com.apamatesoft.repository.FavoriteRepository

class RemoveFavoriteCase(
    private val favoriteRepository: FavoriteRepository
) {

    suspend fun invoke(favorite: Int) {
        try {
            return favoriteRepository.removeFavorite(favorite)
        } catch (_: Exception) { }
    }

}