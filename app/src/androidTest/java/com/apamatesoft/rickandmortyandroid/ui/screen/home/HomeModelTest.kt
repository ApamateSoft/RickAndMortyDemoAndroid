package com.apamatesoft.rickandmortyandroid.ui.screen.home

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.apamatesoft.domain.entity.Character
import com.apamatesoft.domain.entity.CharacterPage
import com.apamatesoft.repository.CharacterRepository
import com.apamatesoft.repository.FavoriteRepository
import com.apamatesoft.repository.localSource.CharacterLocalSource
import com.apamatesoft.repository.localSource.FavoriteLocalSource
import com.apamatesoft.repository.remoteSource.CharacterRemoteSource
import com.apamatesoft.usecase.AddFavoriteCase
import com.apamatesoft.usecase.CharacterRequestCase
import com.apamatesoft.usecase.GetAllFavoritesCase
import com.apamatesoft.usecase.RemoveFavoriteCase
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.stub
import org.mockito.kotlin.verifyNoMoreInteractions
import java.lang.Exception

@RunWith(AndroidJUnit4::class)
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
        private const val DELAY = 100L
    }

    private lateinit var characterRemoteSource: CharacterRemoteSource
    private lateinit var characterLocalSource: CharacterLocalSource
    private lateinit var characterRepository: CharacterRepository

    private lateinit var favoriteLocalSource: FavoriteLocalSource
    private lateinit var favoriteRepository: FavoriteRepository

    private lateinit var useCase: CharacterRequestCase
    private lateinit var addFavoritesCase: AddFavoriteCase
    private lateinit var removeFavoriteCase: RemoveFavoriteCase
    private lateinit var getAllFavoritesCase: GetAllFavoritesCase
    private lateinit var homeModel: HomeModel

    @Before
    fun setUp() {
        characterRemoteSource = Mockito.mock(CharacterRemoteSource::class.java)
        characterLocalSource = CharacterLocalSourceMockImp()
        characterRepository = CharacterRepository(characterRemoteSource, characterLocalSource)

        favoriteLocalSource = Mockito.mock(FavoriteLocalSource::class.java)
        favoriteRepository = FavoriteRepository(favoriteLocalSource)
        addFavoritesCase = AddFavoriteCase(favoriteRepository)
        removeFavoriteCase = RemoveFavoriteCase(favoriteRepository)
        getAllFavoritesCase = GetAllFavoritesCase(favoriteRepository)

        useCase = CharacterRequestCase(characterRepository)
        homeModel = HomeModel(
            useCase,
            addFavoritesCase,
            removeFavoriteCase,
            getAllFavoritesCase
        )
    }

    @Test
    fun characterRequest_ShouldAddAListOfCharacterToTheStateOnSuccess() = runBlocking {
        characterRemoteSource.stub {
            onBlocking { characterRequest(any()) }.doReturn(MOCK_RESPONSE)
        }
        homeModel.characterRequest()
        delay(DELAY)
        assertEquals(MOCK_RESPONSE.characters.size, homeModel.state.characters.size)
        assertFalse(homeModel.state.loading)
    }

    @Test
    fun characterRequest_shouldNotBeExecutedIfTheLoadingStateIsTrue() = runBlocking {
        homeModel.state = homeModel.state.copy(loading = true)
        homeModel.characterRequest()
        delay(DELAY)
        verifyNoMoreInteractions(characterRemoteSource)
    }

    @Test
    fun characterRequest_mustSetTheHasNetworkErrorStateToTrueOnError() = runBlocking {
        characterRemoteSource.stub {
            onBlocking { characterRequest(any()) }.doAnswer { throw Exception() }
        }
        homeModel.characterRequest()
        delay(DELAY)
        assertTrue(homeModel.state.hasNetworkError)
        assertFalse(homeModel.state.loading)
    }

    @Test
    fun loadMoreCharacters_ShouldAddAListOfCharacterToTheStateOnSuccess() = runBlocking {
        characterRemoteSource.stub {
            onBlocking { characterRequest(any()) }.doReturn(MOCK_RESPONSE)
        }
        homeModel.characterRequest()
        delay(DELAY)
        homeModel.loadMoreCharacters()
        delay(DELAY)
        assertEquals(2*MOCK_RESPONSE.characters.size, homeModel.state.characters.size)
        assertFalse(homeModel.state.loading)
    }

    @Test
    fun loadMoreCharacters_shouldNotBeExecutedIfTheLoadingStateIsTrue() = runBlocking {
        homeModel.state = homeModel.state.copy(loading = true)
        homeModel.loadMoreCharacters()
        delay(DELAY)
        verifyNoMoreInteractions(characterRemoteSource)
    }

    @Test
    fun loadMoreCharacters_mustSetTheHasNetworkErrorStateToTrueOnError() = runBlocking {
        characterRemoteSource.stub {
            onBlocking { characterRequest(any()) }.doAnswer { throw Exception() }
        }
        homeModel.loadMoreCharacters()
        delay(DELAY)
        assertTrue(homeModel.state.hasNetworkError)
        assertFalse(homeModel.state.loading)
    }

    @Test
    fun loadCharactersFromCache_shouldNotMutateTheListOfCharactersIfItExecutesMoreThanNumberOfPages() = runBlocking {
        characterRemoteSource.stub {
            onBlocking { characterRequest(any()) }.doReturn(MOCK_RESPONSE)
        }
        homeModel.characterRequest()
        delay(DELAY)
        homeModel.loadMoreCharacters()
        delay(DELAY)
        homeModel.loadMoreCharacters()
        delay(DELAY)
        homeModel.loadMoreCharacters()
        delay(DELAY)
        assertEquals(3*MOCK_RESPONSE.characters.size, homeModel.state.characters.size)
        assertFalse(homeModel.state.loading)
    }

    @Test
    fun loadCharactersFromCache_shouldSetTheCharacterListStateIfTheCharacterRequestMethodIsSuccessful() = runBlocking {
        characterRemoteSource.stub {
            onBlocking { characterRequest(any()) }.doReturn(MOCK_RESPONSE)
        }
        homeModel.characterRequest()
        delay(DELAY)
        homeModel.state = homeModel.state.copy(characters = emptyList())
        homeModel.loadCharactersFromCache()
        delay(DELAY)
        assertEquals(MOCK_RESPONSE.characters.size, homeModel.state.characters.size)
        assertFalse(homeModel.state.loading)
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