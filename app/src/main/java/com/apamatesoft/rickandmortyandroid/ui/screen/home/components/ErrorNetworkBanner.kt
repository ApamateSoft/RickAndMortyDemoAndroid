package com.apamatesoft.rickandmortyandroid.ui.screen.home.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apamatesoft.rickandmortyandroid.R.drawable.ic_cloud_off
import com.apamatesoft.rickandmortyandroid.R.string.an_error_has_occurred
import com.apamatesoft.rickandmortyandroid.ui.theme.RickAndMortyAndroidTheme

@Composable
fun ErrorNetworkBanner() {

    Row(
        modifier = Modifier
            .testTag("ErrorNetworkBanner")
            .background(Red)
            .fillMaxWidth(),
        verticalAlignment = CenterVertically,
        horizontalArrangement = spacedBy(8.dp, CenterHorizontally)
    ) {
        Text(
            text = stringResource(an_error_has_occurred),
            color = White
        )
        Icon(
            painter = painterResource(ic_cloud_off),
            contentDescription = null,
            tint = White,
            modifier = Modifier.testTag(ic_cloud_off.toString())
        )
    }

}

@Preview(showBackground = true)
@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun PreviewErrorNetworkBanner() {
    RickAndMortyAndroidTheme {
        Surface {
            ErrorNetworkBanner()
        }
    }
}

