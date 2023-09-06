package com.apamatesoft.rickandmortyandroid.ui.screen.home.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apamatesoft.domain.entity.Character
import com.apamatesoft.rickandmortyandroid.R
import com.apamatesoft.rickandmortyandroid.ui.screen.home.HomeModel
import com.apamatesoft.rickandmortyandroid.ui.theme.RickAndMortyAndroidTheme

@Composable
fun HomeContent(
    state: HomeModel.State,
    onItemClick: (Character) -> Unit,
    onAddToFavorite: (Character) -> Unit,
    onRemoveFromFavorite: (Character) -> Unit,
    onLoadMore: () -> Unit,
    onRetry: () -> Unit
) {

    if (state.characters.isEmpty()) {
        if (state.hasNetworkError)
            ErrorNetwork(onRetry = onRetry)
        else
            CharacterListSkeleton()
    } else {
        Column(Modifier.fillMaxWidth()) {

            if (state.hasNetworkError)
                Row(
                    modifier = Modifier
                        .background(Color.Red)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = stringResource(id = R.string.an_error_has_occurred),
                        color = Color.White
                    )
                    Icon(
                        painter = painterResource(R.drawable.ic_cloud_off),
                        contentDescription = null,
                        tint = Color.White
                    )
                }

            CharacterList(
                characters = state.characters,
                isLoading = state.loading,
                favoriteList = state.favorites,
                onItemClick = onItemClick,
                onAddToFavorite = onAddToFavorite,
                onRemoveFromFavorite = onRemoveFromFavorite,
                onLoadMore = onLoadMore
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
private fun PreviewHomeContent() {
    RickAndMortyAndroidTheme {
        Surface {
            HomeContent(
                state = HomeModel.State(
                    hasNetworkError = true,
                    loading = true,
                    characters = (0..19).map {
                        Character(
                            id = it,
                            name = "$it - Name",
                            imageUrl = "https://picsum.photos/id/${it}/128"
                        )
                    }
                ),
                onItemClick = { },
                onAddToFavorite = { },
                onRemoveFromFavorite = { },
                onLoadMore = { },
                onRetry = { }
            )
        }
    }
}

