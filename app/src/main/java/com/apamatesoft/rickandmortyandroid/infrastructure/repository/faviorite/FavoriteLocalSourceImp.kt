package com.apamatesoft.rickandmortyandroid.infrastructure.repository.faviorite

import com.apamatesoft.repository.localSource.FavoriteLocalSource
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.FavoriteDao
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.entity.FavoriteEntity
import javax.inject.Inject

class FavoriteLocalSourceImp @Inject constructor(
    private val dao: FavoriteDao
): FavoriteLocalSource {

    override suspend fun addFavorite(favorite: Int) {
        dao.insert(FavoriteEntity(favorite))
    }

    override suspend fun removeFavorite(favorite: Int) {
        dao.delete(FavoriteEntity(favorite))
    }

    override suspend fun loadFavorites(): List<Int> {
        return dao.getAll().map { it.id }
    }

}