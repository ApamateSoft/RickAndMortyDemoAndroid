package com.apamatesoft.rickandmortyandroid.infrastructure.repository.character

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.apamatesoft.domain.entity.Character
import com.apamatesoft.repository.localSource.CharacterLocalSource
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.AppDatabase
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.CharacterDao
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CharacterLocalSourceImpTest {

    private lateinit var dao: CharacterDao
    private lateinit var db: AppDatabase
    private lateinit var localSource: CharacterLocalSource

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        dao = db.getCharacterDao()
        localSource = CharacterLocalSourceImp(dao)
    }

    @After
    fun tearDown() {
        db.clearAllTables()
        db.close()
    }

    @Test
    fun writeCharactersAndReadCharacters() = runBlocking {
        val characters = (1..20).map {
            Character(
                id = it,
                name = "$it - Name",
                imageUrl = "https://picsum.photos/id/${it}/40"
            )
        }
        localSource.saveCharacters(characters)
        val charactersLoaded = localSource.loadCharacters()
        assertEquals(characters.size, charactersLoaded.size)
    }

    @Test
    fun equalRecordsShouldNotBeDuplicatedInTheDatabase() = runBlocking {
        val characters = listOf(
            Character(
                id = 0,
                name = "$0 - Name",
                imageUrl = "https://picsum.photos/id/0/40"
            )
        )
        localSource.saveCharacters(characters)
        localSource.saveCharacters(characters)
        val charactersLoaded = localSource.loadCharacters()
        assertEquals(1, charactersLoaded.size)
    }

    @Test
    fun clearShouldEmptyCache() = runBlocking {
        val characters = (1..20).map {
            Character(
                id = it,
                name = "$it - Name",
                imageUrl = "https://picsum.photos/id/${it}/40"
            )
        }
        localSource.saveCharacters(characters)
        localSource.clear()
        val loaded = localSource.loadCharacters()
        assertEquals(0, loaded.size)
    }

}