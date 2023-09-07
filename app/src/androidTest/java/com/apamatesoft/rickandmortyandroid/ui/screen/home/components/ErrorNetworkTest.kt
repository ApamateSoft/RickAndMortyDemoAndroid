package com.apamatesoft.rickandmortyandroid.ui.screen.home.components

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import com.apamatesoft.rickandmortyandroid.R.drawable.ic_cloud_off
import com.apamatesoft.rickandmortyandroid.R.string.an_error_has_occurred
import com.apamatesoft.rickandmortyandroid.R.string.retry
import org.mockito.kotlin.verify

class ErrorNetworkTest {

    @get:Rule
    val rule = createAndroidComposeRule<ComponentActivity>()

    @Mock
    private lateinit var retryHandle: () -> Unit

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun allItemShouldBeDisplayed() {

        rule.setContent {
            ErrorNetwork(onRetry = retryHandle)
        }

        rule.onNodeWithTag(ic_cloud_off.toString()).assertIsDisplayed()
        rule.onNodeWithText(rule.activity.getString(an_error_has_occurred)).assertIsDisplayed()
        rule.onNodeWithText(rule.activity.getString(retry)).assertIsDisplayed()

    }

    @Test
    fun onRetry_shouldBeCalledToClickButton() {

        rule.setContent {
            ErrorNetwork(onRetry = retryHandle)
        }

        rule.onNodeWithText(rule.activity.getString(retry)).performClick()

        verify(retryHandle).invoke()

    }

}