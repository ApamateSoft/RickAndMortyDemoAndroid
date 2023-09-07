package com.apamatesoft.rickandmortyandroid.ui.screen.home.components

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class CharacterListSkeletonTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun allItemsShouldBeDisplayed() {

        rule.setContent {
            CharacterListSkeleton()
        }

        rule.onAllNodes(hasTestTag("CharacterItemSkeleton")).assertCountEquals(6)

    }

}