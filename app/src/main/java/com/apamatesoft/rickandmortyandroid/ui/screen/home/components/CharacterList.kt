package com.apamatesoft.rickandmortyandroid.ui.screen.home.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.apamatesoft.domain.entity.Character
import com.apamatesoft.rickandmortyandroid.ui.theme.RickAndMortyAndroidTheme

@Composable
fun CharacterList(
    characters: List<Character> = emptyList(),
    favoriteList: List<Int> = emptyList(),
    onItemClick: (Character) -> Unit,
    onAddToFavorite: (Character) -> Unit,
    onRemoveFromFavorite: (Character) -> Unit,
) {

    LazyColumn {
        items(characters) {
            CharacterItem(
                character = it,
                isFavorite = favoriteList.any { id -> id == it.id },
                onClick = onItemClick,
                onRemoveFromFavorite = onRemoveFromFavorite,
                onAddToFavorite = onAddToFavorite
            )
            Divider()
        }
    }

}

@Preview(showBackground = true)
@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun PreviewCharacterList() {
    RickAndMortyAndroidTheme {
        Surface {
            CharacterList(
                characters = (0..9).map {
                    Character(
                        id = it,
                        name = "$it - Name",
                        imageUrl = "https://picsum.photos/id/${it}/128"
                    )
                },
                favoriteList = listOf(0),
                onItemClick = { },
                onRemoveFromFavorite = { },
                onAddToFavorite = { }
            )
        } 
    }
}

