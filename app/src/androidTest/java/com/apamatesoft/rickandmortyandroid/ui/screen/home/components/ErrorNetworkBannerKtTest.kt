package com.apamatesoft.rickandmortyandroid.ui.screen.home.components

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test
import com.apamatesoft.rickandmortyandroid.R.drawable.ic_cloud_off
import com.apamatesoft.rickandmortyandroid.R.string.an_error_has_occurred

class ErrorNetworkBannerKtTest {

    @get:Rule
    val rule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun allItemsShouldBeDisplayed() {

        rule.setContent {
            ErrorNetworkBanner()
        }

        rule.onNodeWithText(rule.activity.getString(an_error_has_occurred)).assertIsDisplayed()
        rule.onNodeWithTag(ic_cloud_off.toString())

    }

}