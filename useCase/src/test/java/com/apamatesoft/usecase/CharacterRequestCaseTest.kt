package com.apamatesoft.usecase

import com.apamatesoft.domain.entity.Character
import com.apamatesoft.domain.entity.CharacterPage
import com.apamatesoft.repository.CharacterRepository
import com.apamatesoft.repository.localSource.CharacterLocalSource
import com.apamatesoft.repository.remoteSource.CharacterRemoteSource
import junit.framework.TestCase.assertEquals
import org.junit.Test
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.stub
import java.lang.Exception

class CharacterRequestCaseTest {

    companion object {
        private val MOCK_RESPONSE = CharacterPage(
            characters = (0..9).map {
                Character(
                    id = it+10,
                    name = "Name",
                    imageUrl = "https://picsum.photos/id/1/128"
                )
            },
            pages = 3
        )
    }

    private lateinit var remoteSource: CharacterRemoteSource
    private lateinit var localSource: CharacterLocalSource
    private lateinit var repo: CharacterRepository
    private lateinit var useCase: CharacterRequestCase

    @Before
    fun setUp() {
        remoteSource = Mockito.mock(CharacterRemoteSource::class.java)
        localSource = CharacterLocalSourceMockImp()
        repo = CharacterRepository(remoteSource, localSource)
        useCase = CharacterRequestCase(repo)
    }

    @Test
    fun `characterRequest should return a list of character on success`() = runTest {
        remoteSource.stub {
            onBlocking { characterRequest(any()) }.doReturn(MOCK_RESPONSE)
        }
        val characters = useCase.characterRequest()
        assertEquals(MOCK_RESPONSE.characters.size, characters.size)
    }

    @Test
    fun `loadCharacter should return a list of characters in memory if the characterRequest method was successful`() = runTest {
        remoteSource.stub {
            onBlocking { characterRequest(any()) }.doReturn(MOCK_RESPONSE)
        }
        useCase.characterRequest()
        val cachedCharacters = useCase.loadCharacters()
        assertEquals(MOCK_RESPONSE.characters.size, cachedCharacters.size)
    }

    @Test
    fun `loadMoreCharacters should add character to list on success`() = runTest {
        remoteSource.stub {
            onBlocking { characterRequest(any()) }.doReturn(MOCK_RESPONSE)
        }
        useCase.characterRequest()
        val characters = useCase.loadMoreCharacters()
        assertEquals(2*MOCK_RESPONSE.characters.size, characters.size)
    }

    @Test
    fun `isLastPage should return true when reaching the last page`() = runTest {
        remoteSource.stub {
            onBlocking { characterRequest(any()) }.doReturn(MOCK_RESPONSE)
        }
        useCase.characterRequest()
        useCase.loadMoreCharacters()
        useCase.loadMoreCharacters()
        assertEquals(true, useCase.isLastPage())
    }

    @Test
    fun `loadMoreCharacter should not keep adding characters to the list if it is executed more times than the number of pages`() = runTest {
        remoteSource.stub {
            onBlocking { characterRequest(any()) }.doReturn(MOCK_RESPONSE)
        }
        useCase.characterRequest()
        useCase.loadMoreCharacters()
        useCase.loadMoreCharacters()
        val characters = useCase.loadMoreCharacters()
        assertEquals(3*MOCK_RESPONSE.characters.size, characters.size)
    }

    @Test
    fun `loadMoreCharacters should not increment the current page if an error occurs`() = runTest {
        remoteSource.stub {
            onBlocking { characterRequest(any()) }.doAnswer { throw Exception() }
        }
        try {
            useCase.loadMoreCharacters()
        } catch (_: Exception) {
        }
        assertEquals(1, useCase.currentPage)
    }

}

class CharacterLocalSourceMockImp: CharacterLocalSource {

    private var characters: List<Character> = emptyList()

    override suspend fun saveCharacters(characters: List<Character>) {
        this.characters = characters
    }

    override suspend fun loadCharacters(): List<Character> {
        return characters
    }

}