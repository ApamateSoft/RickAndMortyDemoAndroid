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

class CharacterRequestCaseTest {

    private lateinit var remoteSource: CharacterRemoteSource
    private lateinit var localSource: CharacterLocalSource
    private lateinit var repo: CharacterRepository
    private lateinit var useCase: CharacterRequestCase

    @Before
    fun setUp() {
        remoteSource = CharacterRemoteSourceMockImp()
        localSource = CharacterLocalSourceMockImp()
        repo = CharacterRepository(remoteSource, localSource)
        useCase = CharacterRequestCase(repo)
    }

    @Test
    fun `a list with 10 characters should be returned`() = runTest {
        val characters = useCase.characterRequest()
        assertEquals(10, characters.size)
    }

    @Test
    fun `after a character request should be cached`() = runTest {
        useCase.characterRequest()
        val cachedCharacters = localSource.loadCharacters()
        assertEquals(10, cachedCharacters.size)
    }

    @Test
    fun `when loading more characters, a list must be returned with the current result together with all the previously consulted characters`() = runTest {
        useCase.characterRequest()
        val characters = useCase.loadMoreCharacters()
        assertEquals(20, characters.size)
    }

    @Test
    fun `When reaching the last page, the isLastPage function should return true`() = runTest {
        useCase.characterRequest()
        useCase.loadMoreCharacters()
        useCase.loadMoreCharacters()
        assertEquals(true, useCase.isLastPage())
    }

    @Test
    fun `If it is consulted beyond the last page, the list of characters should not grow`() = runTest {
        useCase.characterRequest()
        useCase.loadMoreCharacters()
        useCase.loadMoreCharacters()
        val characters = useCase.loadMoreCharacters()
        assertEquals(30, characters.size)
    }

}

class CharacterRemoteSourceMockImp: CharacterRemoteSource {

    override suspend fun characterRequest(page: Int): CharacterPage {
        val characters = (0..9).map {
            val id = it+((page-1)*10)
            Character(
                id = id,
                name = "$id-Name",
                imageUrl = "https://picsum.photos/id/$id/128"
            )
        }
        return CharacterPage(
            characters = characters,
            pages = 3
        )
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