package com.apamatesoft.rickandmortyandroid.ui.screen.favorite

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.apamatesoft.rickandmortyandroid.ui.theme.RickAndMortyAndroidTheme

@Composable
fun FavoriteScreen() {

    Box(
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Favoritos")
    }

}

@Preview(showBackground = true)
@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun PreviewFavoriteScreen() {
    RickAndMortyAndroidTheme {
        Surface {
            FavoriteScreen()
        }
    }
}

