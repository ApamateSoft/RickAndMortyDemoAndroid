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

    private lateinit var characterDao: CharacterDao
    private lateinit var db: AppDatabase
    private lateinit var characterLocalSource: CharacterLocalSource

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        characterDao = db.getCharacterDao()
        characterLocalSource = CharacterLocalSourceImp(characterDao)
    }

    @After
    fun tearDown() {
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
        characterLocalSource.saveCharacters(characters)
        val charactersLoaded = characterLocalSource.loadCharacters()
        assertEquals(characters.size, charactersLoaded.size)
    }

}