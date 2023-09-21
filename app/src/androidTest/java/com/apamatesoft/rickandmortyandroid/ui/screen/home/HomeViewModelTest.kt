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
class HomeViewModelTest {

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
    private lateinit var homeViewModel: HomeViewModel

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
        homeViewModel = HomeViewModel(
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
        homeViewModel.characterRequest()
        delay(DELAY)
        assertEquals(MOCK_RESPONSE.characters.size, homeViewModel.state.characters.size)
        assertFalse(homeViewModel.state.loading)
    }

    @Test
    fun characterRequest_shouldNotBeExecutedIfTheLoadingStateIsTrue() = runBlocking {
        homeViewModel.state = homeViewModel.state.copy(loading = true)
        homeViewModel.characterRequest()
        delay(DELAY)
        verifyNoMoreInteractions(characterRemoteSource)
    }

    @Test
    fun characterRequest_mustSetTheHasNetworkErrorStateToTrueOnError() = runBlocking {
        characterRemoteSource.stub {
            onBlocking { characterRequest(any()) }.doAnswer { throw Exception() }
        }
        homeViewModel.characterRequest()
        delay(DELAY)
        assertTrue(homeViewModel.state.hasNetworkError)
        assertFalse(homeViewModel.state.loading)
    }

    @Test
    fun loadMoreCharacters_ShouldAddAListOfCharacterToTheStateOnSuccess() = runBlocking {
        characterRemoteSource.stub {
            onBlocking { characterRequest(any()) }.doReturn(MOCK_RESPONSE)
        }
        homeViewModel.characterRequest()
        delay(DELAY)
        homeViewModel.loadMoreCharacters()
        delay(DELAY)
        assertEquals(2*MOCK_RESPONSE.characters.size, homeViewModel.state.characters.size)
        assertFalse(homeViewModel.state.loading)
    }

    @Test
    fun loadMoreCharacters_shouldNotBeExecutedIfTheLoadingStateIsTrue() = runBlocking {
        homeViewModel.state = homeViewModel.state.copy(loading = true)
        homeViewModel.loadMoreCharacters()
        delay(DELAY)
        verifyNoMoreInteractions(characterRemoteSource)
    }

    @Test
    fun loadMoreCharacters_mustSetTheHasNetworkErrorStateToTrueOnError() = runBlocking {
        characterRemoteSource.stub {
            onBlocking { characterRequest(any()) }.doAnswer { throw Exception() }
        }
        homeViewModel.loadMoreCharacters()
        delay(DELAY)
        assertTrue(homeViewModel.state.hasNetworkError)
        assertFalse(homeViewModel.state.loading)
    }

    @Test
    fun loadCharactersFromCache_shouldNotMutateTheListOfCharactersIfItExecutesMoreThanNumberOfPages() = runBlocking {
        characterRemoteSource.stub {
            onBlocking { characterRequest(any()) }.doReturn(MOCK_RESPONSE)
        }
        homeViewModel.characterRequest()
        delay(DELAY)
        homeViewModel.loadMoreCharacters()
        delay(DELAY)
        homeViewModel.loadMoreCharacters()
        delay(DELAY)
        homeViewModel.loadMoreCharacters()
        delay(DELAY)
        assertEquals(3*MOCK_RESPONSE.characters.size, homeViewModel.state.characters.size)
        assertFalse(homeViewModel.state.loading)
    }

    @Test
    fun loadCharactersFromCache_shouldSetTheCharacterListStateIfTheCharacterRequestMethodIsSuccessful() = runBlocking {
        characterRemoteSource.stub {
            onBlocking { characterRequest(any()) }.doReturn(MOCK_RESPONSE)
        }
        homeViewModel.characterRequest()
        delay(DELAY)
        homeViewModel.state = homeViewModel.state.copy(characters = emptyList())
        homeViewModel.loadCharactersFromCache()
        delay(DELAY)
        assertEquals(MOCK_RESPONSE.characters.size, homeViewModel.state.characters.size)
        assertFalse(homeViewModel.state.loading)
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

    override suspend fun clear() {
        characters = emptyList()
    }

}