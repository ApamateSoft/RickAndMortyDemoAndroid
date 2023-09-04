package com.apamatesoft.rickandmortyandroid.ui.screen.home

import com.apamatesoft.domain.entity.Character
import com.apamatesoft.domain.entity.CharacterPage
import com.apamatesoft.repository.CharacterRepository
import com.apamatesoft.repository.localSource.CharacterLocalSource
import com.apamatesoft.repository.remoteSource.CharacterRemoteSource
import com.apamatesoft.usecase.CharacterRequestCase
import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.stub

class HomeModelTest {

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
    private lateinit var homeModel: HomeModel

    @Before
    fun setUp() {
        remoteSource = Mockito.mock(CharacterRemoteSource::class.java)
        localSource = CharacterLocalSourceMockImp()
        repo = CharacterRepository(remoteSource, localSource)
        useCase = CharacterRequestCase(repo)
        homeModel = HomeModel(useCase)
    }

    @Test
    fun test1() = runTest {
        remoteSource.stub {
            onBlocking { characterRequest(any()) }.doReturn(MOCK_RESPONSE)
        }
        homeModel.characterRequest()
        TestCase.assertEquals(10, homeModel.state.characters.size)
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