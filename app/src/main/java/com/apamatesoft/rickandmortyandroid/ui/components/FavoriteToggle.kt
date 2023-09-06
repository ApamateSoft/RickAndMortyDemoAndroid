package com.apamatesoft.rickandmortyandroid.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.apamatesoft.rickandmortyandroid.R.drawable.ic_favorite_fill
import com.apamatesoft.rickandmortyandroid.R.drawable.ic_favorite_border
import com.apamatesoft.rickandmortyandroid.R.string.favorite_toggle_icon_description
import com.apamatesoft.rickandmortyandroid.ui.theme.RickAndMortyAndroidTheme

@Composable
fun FavoriteToggle(
    isFavorite: Boolean = false,
    onAddToFavorite: () -> Unit,
    onRemoveFromFavorite: () -> Unit
) {

    val painterId = if (isFavorite) ic_favorite_fill else ic_favorite_border

    IconButton(
        onClick = if (isFavorite) onRemoveFromFavorite else onAddToFavorite
    ) {
        Icon(
            modifier = Modifier.testTag(painterId.toString()),
            painter = painterResource(id = painterId),
            contentDescription = stringResource(id = favorite_toggle_icon_description),
            tint = if (isFavorite) Red else Gray
        )
    }

}

@Preview(showBackground = true)
@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun PreviewFavoriteButton() {
    RickAndMortyAndroidTheme {
        Surface {
            FavoriteToggle(
                onAddToFavorite = {},
                onRemoveFromFavorite = {}
            )
        }
    }
}

