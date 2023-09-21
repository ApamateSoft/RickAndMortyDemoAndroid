package com.apamatesoft.rickandmortyandroid.ui.components

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeUp
import com.apamatesoft.domain.entity.Character
import com.apamatesoft.rickandmortyandroid.R.string.favorite_toggle_icon_description
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import com.apamatesoft.rickandmortyandroid.R.drawable.ic_favorite_fill
import com.apamatesoft.rickandmortyandroid.R.drawable.ic_favorite_border
import junit.framework.TestCase
import org.junit.Before
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoInteractions

class CharacterListTest {

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
    private lateinit var clickHandle: (Character) -> Unit
    @Mock
    private lateinit var addToFavoriteHandle: (Character) -> Unit
    @Mock
    private lateinit var removeFromFavoriteHandle: (Character) -> Unit
    @Mock
    private lateinit var loadMoreHandle: () -> Unit

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun allItemsShouldBeDisplayed() {
        rule.setContent {
            CharacterList(
                characters = CHARACTERS,
                onItemClick = { },
                onAddToFavorite = { },
                onRemoveFromFavorite = { },
                onLoadMore = { }
            )
        }

        rule.onAllNodes(hasTestTag("CharacterItem")).assertCountEquals(CHARACTERS.size)

    }

    @Test
    fun onlyOneItemShouldBeFavorite() {
        rule.setContent {
            CharacterList(
                characters = CHARACTERS,
                favoriteList = FAVORITES,
                onItemClick = { },
                onAddToFavorite = { },
                onRemoveFromFavorite = { },
                onLoadMore = { }
            )
        }

        rule.onAllNodesWithTag(ic_favorite_fill.toString(), useUnmergedTree = true).assertCountEquals(1)
        rule.onAllNodesWithTag(ic_favorite_border.toString(), useUnmergedTree = true).assertCountEquals(
            CHARACTERS.size-1)

    }

    @Test
    fun onClick_shouldBeCalledIfPressCharacterItem() {

        var character: Character? = null
        val index = 0

        rule.setContent {
            CharacterList(
                characters = CHARACTERS,
                favoriteList = FAVORITES,
                onItemClick = { character = it },
                onAddToFavorite = addToFavoriteHandle,
                onRemoveFromFavorite = removeFromFavoriteHandle,
                onLoadMore = { }
            )
        }

        rule.onAllNodes(hasTestTag("CharacterItem"))[index].performClick()

        TestCase.assertNotNull(character)
        TestCase.assertEquals(CHARACTERS[index].name, character?.name)
        verifyNoInteractions(addToFavoriteHandle)
        verifyNoInteractions(removeFromFavoriteHandle)

    }

    @Test
    fun onAddToFavorite_shouldBeCalledIfThe_isFavoritePropertyIsFalse() {

        val index = 1
        var character: Character? = null

        rule.setContent {
            CharacterList(
                characters = CHARACTERS,
                favoriteList = FAVORITES,
                onItemClick = clickHandle,
                onAddToFavorite = { character = it },
                onRemoveFromFavorite = removeFromFavoriteHandle,
                onLoadMore = { }
            )
        }

        val label = rule.activity.getString(favorite_toggle_icon_description)
        rule.onAllNodesWithContentDescription(label, useUnmergedTree = true)[index].performClick()

        TestCase.assertNotNull(character)
        TestCase.assertEquals(CHARACTERS[index].name, character?.name)
        verifyNoInteractions(clickHandle)
        verifyNoInteractions(removeFromFavoriteHandle)

    }

    @Test
    fun onRemoveFromFavorite_shouldBeCalledIfThe_isFavoritePropertyIsTrue() {

        val index = 0
        var character: Character? = null

        rule.setContent {
            CharacterList(
                characters = CHARACTERS,
                favoriteList = FAVORITES,
                onItemClick = clickHandle,
                onAddToFavorite = addToFavoriteHandle,
                onRemoveFromFavorite = { character = it },
                onLoadMore = { }
            )
        }

        val label = rule.activity.getString(favorite_toggle_icon_description)
        rule.onAllNodesWithContentDescription(label, useUnmergedTree = true)[index].performClick()

        TestCase.assertNotNull(character)
        TestCase.assertEquals(CHARACTERS[index].name, character?.name)
        verifyNoInteractions(clickHandle)
        verifyNoInteractions(addToFavoriteHandle)

    }

    @Test
    fun onLoadMore_shouldBeCalledToSwipeUpGesture() {

        rule.setContent {
            CharacterList(
                characters = CHARACTERS + CHARACTERS,
                favoriteList = FAVORITES,
                onItemClick = clickHandle,
                onAddToFavorite = addToFavoriteHandle,
                onRemoveFromFavorite = removeFromFavoriteHandle,
                onLoadMore = loadMoreHandle
            )
        }

        rule.onRoot().performTouchInput {
            swipeUp()
            swipeUp()
            swipeUp()
            swipeUp()
        }

        verify(loadMoreHandle, times(2)).invoke()

    }

}