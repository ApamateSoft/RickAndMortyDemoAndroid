package com.apamatesoft.rickandmortyandroid.infrastructure.repository.mapper

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.model.FavoriteModel
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FavoriteMapperTest {

    @Test
    fun favoriteModelToFavorite() {
        val model = FavoriteModel(1)
        val entity = model.toEntity()
        assertEquals(model.id, entity)
    }

    @Test
    fun favoriteToFavoriteModel() {
        val entity = 7
        val model = entity.toModel()
        assertEquals(entity, model.id)
    }

}