package com.apamatesoft.rickandmortyandroid.infrastructure.repository.favorite

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.apamatesoft.repository.localSource.FavoriteLocalSource
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.AppDatabase
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.FavoriteDao
import com.apamatesoft.rickandmortyandroid.infrastructure.repository.faviorite.FavoriteLocalSourceImp
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FavoriteLocalSourceImpTest {

    private lateinit var dao: FavoriteDao
    private lateinit var db: AppDatabase
    private lateinit var localSource: FavoriteLocalSource

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        dao = db.getFavoriteDao()
        localSource = FavoriteLocalSourceImp(dao)
    }

    @After
    fun tearDown() {
        db.clearAllTables()
        db.close()
    }

    @Test
    fun writeAndRead() = runBlocking {
        localSource.addFavorite(52)
        val loaded = localSource.loadFavorites()
        Assert.assertEquals(1, loaded.size)
        Assert.assertEquals(52, loaded.first())
    }

    @Test
    fun delete() = runBlocking {
        val entities = (1..2).toList()
        entities.forEach { localSource.addFavorite(it) }
        localSource.removeFavorite(entities.first())
        val loaded = localSource.loadFavorites()
        Assert.assertEquals(entities.size - 1, loaded.size)
        Assert.assertEquals(2, loaded.first())
    }

    @Test
    fun equalRecordsShouldNotBeDuplicatedInTheDatabase() = runBlocking {
        localSource.addFavorite(1)
        localSource.addFavorite(1)
        val loaded = localSource.loadFavorites()
        Assert.assertEquals(1, loaded.size)
    }

}