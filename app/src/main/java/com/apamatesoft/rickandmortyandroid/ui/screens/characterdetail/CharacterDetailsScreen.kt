package com.apamatesoft.rickandmortyandroid.ui.screens.characterdetail

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.apamatesoft.rickandmortyandroid.ui.theme.RickAndMortyAndroidTheme

@Composable
fun CharacterDetailsScreen() {
    Text("Character detail")
}

@Preview(showBackground = true)
@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun PreviewCharacterDetailScreen() {
    RickAndMortyAndroidTheme {
        Surface {
            CharacterDetailsScreen()
        }
    }
}

