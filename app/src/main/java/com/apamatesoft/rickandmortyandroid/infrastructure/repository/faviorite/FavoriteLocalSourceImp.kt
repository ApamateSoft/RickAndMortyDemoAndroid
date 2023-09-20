package com.apamatesoft.rickandmortyandroid.infrastructure.repository.faviorite

import com.apamatesoft.repository.localSource.FavoriteLocalSource
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.FavoriteDao
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.model.FavoriteModel
import com.apamatesoft.rickandmortyandroid.infrastructure.repository.mapper.toEntity
import com.apamatesoft.rickandmortyandroid.infrastructure.repository.mapper.toModel
import javax.inject.Inject

class FavoriteLocalSourceImp @Inject constructor(
    private val dao: FavoriteDao
): FavoriteLocalSource {

    override suspend fun addFavorite(favorite: Int) {
        dao.insert(favorite.toModel())
    }

    override suspend fun removeFavorite(favorite: Int) {
        dao.delete(favorite.toModel())
    }

    override suspend fun loadFavorites(): List<Int> {
        return dao.getAll().map { it.toEntity() }
    }

}