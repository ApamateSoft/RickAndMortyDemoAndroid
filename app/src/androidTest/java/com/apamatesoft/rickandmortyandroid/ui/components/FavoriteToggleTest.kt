package com.apamatesoft.rickandmortyandroid.ui.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verifyNoInteractions
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify
import com.apamatesoft.rickandmortyandroid.R.drawable.ic_favorite_fill
import com.apamatesoft.rickandmortyandroid.R.drawable.ic_favorite_border

class FavoriteToggleTest {

    @get:Rule
    val rule = createComposeRule()

    @Mock
    private lateinit var addToFavoriteHandle: () -> Unit
    @Mock
    private lateinit var removeFromFavoriteHandle: () -> Unit

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun checkThatCorrectIconIsDisplayedIs_isFavoriteIsTrue() {
        rule.setContent {
            FavoriteToggle(
                isFavorite = true,
                onAddToFavorite = addToFavoriteHandle,
                onRemoveFromFavorite = removeFromFavoriteHandle
            )
        }
        rule.onNodeWithTag(ic_favorite_fill.toString(), useUnmergedTree = true).assertIsDisplayed()
    }

    @Test
    fun checkThatCorrectIconIsDisplayedIs_isFavoriteIsFalse() {
        rule.setContent {
            FavoriteToggle(
                isFavorite = false,
                onAddToFavorite = addToFavoriteHandle,
                onRemoveFromFavorite = removeFromFavoriteHandle
            )
        }
        rule.onNodeWithTag(ic_favorite_border.toString(), useUnmergedTree = true).assertIsDisplayed()
    }

    @Test
    fun onAddToFavorite_shouldBeCalledIfThe_isFavoritePropertyIsFalse() {
        rule.setContent {
            FavoriteToggle(
                isFavorite = false,
                onAddToFavorite = addToFavoriteHandle,
                onRemoveFromFavorite = removeFromFavoriteHandle
            )
        }
        rule.onRoot().performClick()
        verify(addToFavoriteHandle).invoke()
        verifyNoInteractions(removeFromFavoriteHandle)
    }

    @Test
    fun onRemoveFromFavorite_shouldBeCalledIfThe_isFavoritePropertyIsTrue() {
        rule.setContent {
            FavoriteToggle(
                isFavorite = true,
                onAddToFavorite = addToFavoriteHandle,
                onRemoveFromFavorite = removeFromFavoriteHandle
            )
        }
        rule.onRoot().performClick()
        verify(removeFromFavoriteHandle).invoke()
        verifyNoInteractions(addToFavoriteHandle)
    }

}