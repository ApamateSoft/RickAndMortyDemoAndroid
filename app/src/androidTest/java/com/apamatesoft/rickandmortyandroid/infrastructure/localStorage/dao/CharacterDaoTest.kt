package com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.AppDatabase
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.model.CharacterModel
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CharacterDaoTest {

    private lateinit var characterDao: CharacterDao
    private lateinit var db: AppDatabase

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        characterDao = db.getCharacterDao()
    }

    @After
    fun tearDown() {
        db.clearAllTables()
        db.close()
    }

    @Test
    fun writeCharactersAndReadCharacters() = runBlocking {
        val characters = (1..20).map {
            CharacterModel(
                id = it,
                name = "$it - Name",
                imageUrl = "https://picsum.photos/id/${it}/40"
            )
        }
        characters.forEach {
            characterDao.insert(it)
        }
        val charactersLoaded = characterDao.getAll()
        assertEquals(characters.size, charactersLoaded.size)
    }

    @Test
    fun equalRecordsShouldNotBeDuplicatedInTheDatabase() {
        val model = CharacterModel(
            id = 1,
            name = "1 - Name",
            imageUrl = "https://picsum.photos/id/1/40"
        )
        characterDao.insert(model)
        characterDao.insert(model)
        val characters = characterDao.getAll()
        assertEquals(1, characters.size)
    }

}