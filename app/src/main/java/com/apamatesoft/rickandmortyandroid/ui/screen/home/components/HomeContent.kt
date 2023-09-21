package com.apamatesoft.rickandmortyandroid.ui.screen.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.apamatesoft.domain.entity.Character
import com.apamatesoft.rickandmortyandroid.ui.components.CharacterList
import com.apamatesoft.rickandmortyandroid.ui.components.CharacterListSkeleton
import com.apamatesoft.rickandmortyandroid.ui.screen.home.HomeViewModel
import com.apamatesoft.rickandmortyandroid.ui.theme.RickAndMortyAndroidTheme

@Composable
fun HomeContent(
    state: HomeViewModel.State,
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

            if (state.hasNetworkError) ErrorNetworkBanner()

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
//@Preview(
//    showBackground = true,
//    uiMode = UI_MODE_NIGHT_YES
//)
@Composable
private fun PreviewHomeContent() {
    RickAndMortyAndroidTheme {
        Surface {
            HomeContent(
                state = HomeViewModel.State(
                    characters = (0..19).map {
                        Character(
                            id = it,
                            name = "$it - Name",
                            imageUrl = "https://picsum.photos/id/${it}/40"
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

