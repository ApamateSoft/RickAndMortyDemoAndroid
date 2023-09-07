package com.apamatesoft.rickandmortyandroid.ui.screen.home.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apamatesoft.rickandmortyandroid.R.drawable.ic_cloud_off
import com.apamatesoft.rickandmortyandroid.R.string.an_error_has_occurred
import com.apamatesoft.rickandmortyandroid.R.string.retry
import com.apamatesoft.rickandmortyandroid.ui.theme.RickAndMortyAndroidTheme

@Composable
fun ErrorNetwork(
    onRetry: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize().testTag("ErrorNetwork"),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            painter = painterResource(ic_cloud_off),
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .testTag(ic_cloud_off.toString())
        )

        Spacer(modifier = Modifier.weight(0.5f))

        Text(text = stringResource(an_error_has_occurred))

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onRetry
        ) {
            Text(text = stringResource(retry))
        }

        Spacer(modifier = Modifier.weight(1f))

    }

}

@Preview(showBackground = true)
@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun PreviewErrorNetwork() {
    RickAndMortyAndroidTheme {
        Surface {
            ErrorNetwork(
                onRetry = { }
            )
        }
    }
}

