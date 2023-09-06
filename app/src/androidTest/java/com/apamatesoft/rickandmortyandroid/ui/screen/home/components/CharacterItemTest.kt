package com.apamatesoft.rickandmortyandroid.ui.screen.home.components

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import com.apamatesoft.domain.entity.Character
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Rule
import org.junit.Test
import com.apamatesoft.rickandmortyandroid.R.string.favorite_toggle_icon_description
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verifyNoInteractions

class CharacterItemTest {

    companion object {
        private val CHARACTER = Character(
            id = 0,
            name = "Lorem Ipsum",
            imageUrl = "https://picsum.photos/id/1/128"
        )
    }

    @Mock
    private lateinit var onClickHandle: (Character) -> Unit
    @Mock
    private lateinit var addToFavoriteHandle: (Character) -> Unit
    @Mock
    private lateinit var removeFromFavoriteHandle: (Character) -> Unit

    @get:Rule
    val rule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun characterItem_showItems() {

        rule.setContent {
            CharacterItem(
                character = CHARACTER,
                onClick = {  },
                onAddToFavorite = {  },
                onRemoveFromFavorite = {  }
            )
        }

        val label = rule.activity.getString(favorite_toggle_icon_description)

        rule.onNodeWithContentDescription(CHARACTER.imageUrl).assertIsDisplayed()
        rule.onNodeWithText(CHARACTER.name).assertIsDisplayed()
        rule.onNodeWithContentDescription(label).assertIsDisplayed()

    }

    @Test
    fun onClick_shouldBeCalledIfPressCharacterItem() {

        var character: Character? = null

        rule.setContent {
            CharacterItem(
                character = CHARACTER,
                onClick = { character = it },
                onAddToFavorite = addToFavoriteHandle,
                onRemoveFromFavorite = removeFromFavoriteHandle
            )
        }

        rule.onRoot().performClick()

        assertNotNull(character)
        assertEquals(CHARACTER.name, character?.name)
        verifyNoInteractions(addToFavoriteHandle)
        verifyNoInteractions(removeFromFavoriteHandle)

    }

    @Test
    fun onAddToFavorite_shouldBeCalledIfThe_isFavoritePropertyIsFalse() {

        var character: Character? = null

        rule.setContent {
            CharacterItem(
                character = CHARACTER,
                onClick = onClickHandle,
                onAddToFavorite = { character = it },
                onRemoveFromFavorite = removeFromFavoriteHandle
            )
        }

        val label = rule.activity.getString(favorite_toggle_icon_description)
        rule.onNodeWithContentDescription(label).performClick()

        assertNotNull(character)
        assertEquals(CHARACTER.name, character?.name)
        verifyNoInteractions(onClickHandle)
        verifyNoInteractions(removeFromFavoriteHandle)

    }

    @Test
    fun onRemoveFromFavorite_shouldBeCalledIfThe_isFavoritePropertyIsTrue() {

        var character: Character? = null

        rule.setContent {
            CharacterItem(
                isFavorite = true,
                character = CHARACTER,
                onClick = onClickHandle,
                onAddToFavorite = addToFavoriteHandle,
                onRemoveFromFavorite = { character = it }
            )
        }

        val label = rule.activity.getString(favorite_toggle_icon_description)
        rule.onNodeWithContentDescription(label).performClick()

        assertNotNull(character)
        assertEquals(CHARACTER.name, character?.name)
        verifyNoInteractions(onClickHandle)
        verifyNoInteractions(addToFavoriteHandle)

    }

}