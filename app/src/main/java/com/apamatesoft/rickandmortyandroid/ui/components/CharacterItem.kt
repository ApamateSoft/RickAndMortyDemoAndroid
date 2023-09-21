package com.apamatesoft.rickandmortyandroid.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ListItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
//import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.apamatesoft.rickandmortyandroid.ui.theme.RickAndMortyAndroidTheme
import com.apamatesoft.domain.entity.Character
import com.apamatesoft.rickandmortyandroid.ui.screen.home.components.CharacterAvatar

@Composable
fun CharacterItem(
    isFavorite: Boolean = false,
    character: Character,
    onClick: (Character) -> Unit,
    onAddToFavorite: (Character) -> Unit,
    onRemoveFromFavorite: (Character) -> Unit
) {

    ListItem(
        modifier = Modifier
            .clickable { onClick(character) }
            .testTag("CharacterItem"),
        leadingContent = {
            CharacterAvatar(url = character.imageUrl)
        },
        headlineContent = {
            Text(
                text = character.name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth()
            )
        },
        trailingContent = {
            FavoriteToggle(
                isFavorite = isFavorite,
                onAddToFavorite = { onAddToFavorite(character) },
                onRemoveFromFavorite = { onRemoveFromFavorite(character) },
            )
        }
    )

    /*
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
     */

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
                    name = "Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum",
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

