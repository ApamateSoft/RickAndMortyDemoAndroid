package com.apamatesoft.rickandmortyandroid.ui.screen.home.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import org.junit.Rule
import org.junit.Test

class CharacterAvatarTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun rootShouldBeShow() {
        rule.setContent {
            CharacterAvatar(url = "https://picsum.photos/id/1/40")
        }
        rule.onRoot().assertIsDisplayed()
    }

}
