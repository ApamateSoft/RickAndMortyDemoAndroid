package com.apamatesoft.rickandmortyandroid.ui.screen.home.components

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeUp
import com.apamatesoft.domain.entity.Character
import com.apamatesoft.rickandmortyandroid.R
import com.apamatesoft.rickandmortyandroid.ui.screen.home.HomeViewModel
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoInteractions
import org.mockito.kotlin.verifyNoMoreInteractions

class HomeContentKtTest {

    companion object {
        val CHARACTERS: List<Character> = (0..9).map {
            Character(
                id = it,
                name = "$it - Name",
                imageUrl = "https://picsum.photos/id/${it}/20"
            )
        }
        val FAVORITES = listOf(0)
    }

    @get:Rule
    val rule = createAndroidComposeRule<ComponentActivity>()

    @Mock
    private lateinit var itemClickHandle: (Character) -> Unit
    @Mock
    private lateinit var addToFavoriteHandle: (Character) -> Unit
    @Mock
    private lateinit var removeFromFavoriteHandle: (Character) -> Unit
    @Mock
    private lateinit var loadMoreHandle: () -> Unit
    @Mock
    private lateinit var retryHandle: () -> Unit

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun errorNetwork_shouldBeDisplayedIfCharacterIsEmptyAndHasNetworkErrorIsTrue() {

        rule.setContent {
            HomeContent(
                state = HomeViewModel.State(
                    hasNetworkError = true,
                    characters = emptyList()
                ),
                onItemClick = { },
                onAddToFavorite = { },
                onRemoveFromFavorite = { },
                onLoadMore = { },
                onRetry = { }
            )
        }

        rule.onNodeWithTag("ErrorNetwork").assertIsDisplayed()
        rule.onNodeWithTag("CharacterListSkeleton").assertDoesNotExist()
        rule.onNodeWithTag("CharacterList").assertDoesNotExist()
        rule.onNodeWithTag("ErrorNetworkBanner").assertDoesNotExist()

    }

    @Test
    fun characterListSkeleton_shouldBeDisplayedIfCharacterIsEmptyAnHasNetworkErrorIsFalse() {

        rule.setContent {
            HomeContent(
                state = HomeViewModel.State(
                    hasNetworkError = false,
                    characters = emptyList()
                ),
                onItemClick = { },
                onAddToFavorite = { },
                onRemoveFromFavorite = { },
                onLoadMore = { },
                onRetry = { }
            )
        }

        rule.onNodeWithTag("CharacterListSkeleton").assertIsDisplayed()
        rule.onNodeWithTag("ErrorNetwork").assertDoesNotExist()
        rule.onNodeWithTag("CharacterList").assertDoesNotExist()
        rule.onNodeWithTag("ErrorNetworkBanner").assertDoesNotExist()

    }

    @Test
    fun characterList_shouldBeDisplayedIfCharacterIsNotEmpty() {

        rule.setContent {
            HomeContent(
                state = HomeViewModel.State(
                    characters = CHARACTERS
                ),
                onItemClick = { },
                onAddToFavorite = { },
                onRemoveFromFavorite = { },
                onLoadMore = { },
                onRetry = { }
            )
        }

        rule.onNodeWithTag("CharacterList").assertIsDisplayed()
        rule.onNodeWithTag("ErrorNetwork").assertDoesNotExist()
        rule.onNodeWithTag("CharacterListSkeleton").assertDoesNotExist()
        rule.onNodeWithTag("ErrorNetworkBanner").assertDoesNotExist()

    }

    @Test
    fun errorNetworkBanner_shouldBeDisplayedIfCharacterIsNotEmptyAndHasNetworkErrorIsTrue() {

        rule.setContent {
            HomeContent(
                state = HomeViewModel.State(
                    hasNetworkError = true,
                    characters = CHARACTERS
                ),
                onItemClick = { },
                onAddToFavorite = { },
                onRemoveFromFavorite = { },
                onLoadMore = { },
                onRetry = { }
            )
        }

        rule.onNodeWithTag("CharacterList").assertIsDisplayed()
        rule.onNodeWithTag("ErrorNetworkBanner").assertIsDisplayed()
        rule.onNodeWithTag("ErrorNetwork").assertDoesNotExist()
        rule.onNodeWithTag("CharacterListSkeleton").assertDoesNotExist()

    }

    @Test
    fun onRetry_shouldBeCalledToClickButton() {

        rule.setContent {
            HomeContent(
                state = HomeViewModel.State(
                    hasNetworkError = true
                ),
                onItemClick = itemClickHandle,
                onAddToFavorite = addToFavoriteHandle,
                onRemoveFromFavorite = removeFromFavoriteHandle,
                onLoadMore = loadMoreHandle,
                onRetry = retryHandle
            )
        }

        rule.onNodeWithText(rule.activity.getString(R.string.retry)).performClick()

        verify(retryHandle).invoke()
        verifyNoInteractions(itemClickHandle)
        verifyNoInteractions(addToFavoriteHandle)
        verifyNoInteractions(removeFromFavoriteHandle)
        verifyNoMoreInteractions(loadMoreHandle)

    }

    @Test
    fun onItemClick_shouldBeCalledIfPressCharacterItem() {

        var character: Character? = null
        val index = 0

        rule.setContent {
            HomeContent(
                state = HomeViewModel.State(
                    characters = CHARACTERS
                ),
                onItemClick = { character = it },
                onAddToFavorite = addToFavoriteHandle,
                onRemoveFromFavorite = removeFromFavoriteHandle,
                onLoadMore = loadMoreHandle,
                onRetry = retryHandle
            )
        }

        rule.onAllNodes(hasTestTag("CharacterItem"))[index].performClick()

        assertNotNull(character)
        assertEquals(CHARACTERS[index].name, character?.name)
        verifyNoInteractions(addToFavoriteHandle)
        verifyNoInteractions(removeFromFavoriteHandle)
        verifyNoInteractions(retryHandle)
        verify(loadMoreHandle, times(1)).invoke()

    }

    @Test
    fun onAddToFavorite_shouldBeCalledIfThe_isFavoritePropertyIsFalse() {

        val index = 1
        var character: Character? = null

        rule.setContent {
            HomeContent(
                state = HomeViewModel.State(
                    characters = CHARACTERS,
                    favorites = FAVORITES
                ),
                onItemClick = itemClickHandle,
                onAddToFavorite = { character = it },
                onRemoveFromFavorite = removeFromFavoriteHandle,
                onLoadMore = loadMoreHandle,
                onRetry = retryHandle
            )
        }

        val label = rule.activity.getString(R.string.favorite_toggle_icon_description)
        rule.onAllNodesWithContentDescription(label, useUnmergedTree = true)[index].performClick()

        assertNotNull(character)
        assertEquals(CHARACTERS[index].name, character?.name)
        verifyNoInteractions(itemClickHandle)
        verifyNoInteractions(removeFromFavoriteHandle)
        verifyNoInteractions(retryHandle)
        verify(loadMoreHandle, times(1)).invoke()

    }

    @Test
    fun onRemoveFromFavorite_shouldBeCalledIfThe_isFavoritePropertyIsTrue() {

        val index = 0
        var character: Character? = null

        rule.setContent {
            HomeContent(
                state = HomeViewModel.State(
                    characters = CHARACTERS,
                    favorites = FAVORITES
                ),
                onItemClick = itemClickHandle,
                onAddToFavorite = addToFavoriteHandle,
                onRemoveFromFavorite = { character = it },
                onLoadMore = loadMoreHandle,
                onRetry = retryHandle
            )
        }

        val label = rule.activity.getString(R.string.favorite_toggle_icon_description)
        rule.onAllNodesWithContentDescription(label, useUnmergedTree = true)[index].performClick()

        assertNotNull(character)
        assertEquals(CHARACTERS[index].name, character?.name)
        verifyNoInteractions(itemClickHandle)
        verifyNoInteractions(addToFavoriteHandle)
        verifyNoInteractions(retryHandle)
        verify(loadMoreHandle, times(1)).invoke()

    }

    @Test
    fun onLoadMore_shouldBeCalledToSwipeUpGesture() {

        rule.setContent {
            HomeContent(
                state = HomeViewModel.State(
                    characters = CHARACTERS + CHARACTERS
                ),
                onItemClick = itemClickHandle,
                onAddToFavorite = addToFavoriteHandle,
                onRemoveFromFavorite = removeFromFavoriteHandle,
                onLoadMore = loadMoreHandle,
                onRetry = retryHandle
            )
        }

        rule.onNodeWithTag("CharacterList").performTouchInput {
            swipeUp()
            swipeUp()
        }

        verifyNoInteractions(removeFromFavoriteHandle)
        verifyNoInteractions(itemClickHandle)
        verifyNoInteractions(addToFavoriteHandle)
        verifyNoInteractions(retryHandle)
        verify(loadMoreHandle, times(2)).invoke()

    }

}