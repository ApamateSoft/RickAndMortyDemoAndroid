package com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.AppDatabase
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.model.FavoriteModel
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FavoriteDaoTest {

    private lateinit var dao: FavoriteDao
    private lateinit var db: AppDatabase

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        dao = db.getFavoriteDao()
    }

    @After
    fun tearDown() {
        db.clearAllTables()
        db.close()
    }

    @Test
    fun writeAndRead() {
        val models = (1..2).map { FavoriteModel(it) }
        models.forEach { dao.insert(it) }
        val loaded = dao.getAll()
        assertEquals(models.size, loaded.size)
    }

    @Test
    fun delete() {
        val models = (1..2).map { FavoriteModel(it) }
        models.forEach { dao.insert(it) }
        dao.delete(models.first())
        val loaded = dao.getAll()
        assertEquals(models.size-1, loaded.size)
        assertEquals(2, loaded.first().id)
    }

    @Test
    fun equalRecordsShouldNotBeDuplicatedInTheDatabase() {
        val model = FavoriteModel(1)
        dao.insert(model)
        dao.insert(model)
        val loaded = dao.getAll()
        assertEquals(1, loaded.size)
    }

}