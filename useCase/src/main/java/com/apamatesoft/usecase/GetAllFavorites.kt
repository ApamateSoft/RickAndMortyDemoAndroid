package com.apamatesoft.usecase

import com.apamatesoft.repository.FavoriteRepository

class GetAllFavorites(
    private val favoriteRepository: FavoriteRepository
) {

    suspend fun invoke(): List<Int> {
        return try {
            favoriteRepository.loadFavorites()
        } catch (_: Exception) {
            emptyList()
        }
    }

}