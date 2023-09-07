package com.apamatesoft.rickandmortyandroid.ui.screen.home.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale.Companion.Fit
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.apamatesoft.rickandmortyandroid.R.drawable.ic_img
import com.apamatesoft.rickandmortyandroid.R.drawable.ic_img_not_found
import com.apamatesoft.rickandmortyandroid.ui.theme.RickAndMortyAndroidTheme

@Composable
fun CharacterAvatar(
    size: Dp = 40.dp,
    url: String
) {
    AsyncImage(
        model = url,
        contentDescription = url,
        modifier = Modifier
            .clip(CircleShape)
            .size(size)
            .background(Color.Gray),
        placeholder = painterResource(ic_img),
        error = painterResource(ic_img_not_found),
        contentScale = Fit
    )
}

@Preview(showBackground = true)
@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun PreviewCharacterAvatar() {
    RickAndMortyAndroidTheme {
        Surface {
            CharacterAvatar(url = "https://picsum.photos/id/1/40")
        }
    }
}

