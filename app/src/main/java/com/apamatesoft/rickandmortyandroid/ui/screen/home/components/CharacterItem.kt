package com.apamatesoft.rickandmortyandroid.ui.screen.home.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apamatesoft.rickandmortyandroid.ui.theme.RickAndMortyAndroidTheme
import com.apamatesoft.domain.entity.Character
import com.apamatesoft.rickandmortyandroid.ui.components.FavoriteToggle

@Composable
fun CharacterItem(
    isFavorite: Boolean = false,
    character: Character,
    onClick: (Character) -> Unit,
    onAddToFavorite: (Character) -> Unit,
    onRemoveFromFavorite: (Character) -> Unit
) {

    Box(
        modifier = Modifier
            .clickable { onClick(character) }
            .fillMaxWidth()
            .testTag("CharacterItem")
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(8.dp)
        ) {

            CharacterAvatar(url = character.imageUrl)

            Box(
                Modifier.weight(1f),
            ) {
                Text(
                    text = character.name,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            FavoriteToggle(
                isFavorite = isFavorite,
                onAddToFavorite = { onAddToFavorite(character) },
                onRemoveFromFavorite = { onRemoveFromFavorite(character) },
            )

        }
    }

}

@Preview(showBackground = true)
@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun PreviewCharacterItem() {
    RickAndMortyAndroidTheme {
        Surface {
            CharacterItem(
                character = Character(
                    id = 0,
                    name = "Lorem Ipsum",
                    imageUrl = "https://picsum.photos/id/1/40"
                ),
                isFavorite = true,
                onClick = { },
                onAddToFavorite = { },
                onRemoveFromFavorite = { },
            )
        }
    }
}

