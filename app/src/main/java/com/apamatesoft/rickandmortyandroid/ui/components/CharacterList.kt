package com.apamatesoft.rickandmortyandroid.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apamatesoft.domain.entity.Character
import com.apamatesoft.rickandmortyandroid.ui.theme.RickAndMortyAndroidTheme

@Composable
fun CharacterList(
    isLoading: Boolean = false,
    characters: List<Character> = emptyList(),
    favoriteList: List<Int> = emptyList(),
    onItemClick: (Character) -> Unit,
    onAddToFavorite: (Character) -> Unit,
    onRemoveFromFavorite: (Character) -> Unit,
    onLoadMore: () -> Unit
) {

    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        modifier = Modifier.testTag("CharacterList")
    ) {
        items(characters) {
            CharacterItem(
                character = it,
                isFavorite = favoriteList.any { id -> id == it.id },
                onClick = onItemClick,
                onRemoveFromFavorite = onRemoveFromFavorite,
                onAddToFavorite = onAddToFavorite
            )
        }

        if (isLoading) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }

    }

    listState.OnBottomReached {
        onLoadMore()
    }

}

@Composable
private fun LazyListState.OnBottomReached(
    loadMore: () -> Unit
) {

    val shouldLoadMore = remember {
        derivedStateOf {
            val lastVisibleItem = layoutInfo.visibleItemsInfo.lastOrNull() ?: return@derivedStateOf true
            lastVisibleItem.index == layoutInfo.totalItemsCount - 1
        }
    }

    LaunchedEffect(shouldLoadMore) {
        snapshotFlow { shouldLoadMore.value }
            .collect {
                if (it) loadMore()
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
                isLoading = true,
                characters = (0..29).map {
                    Character(
                        id = it,
                        name = "$it - Name",
                        imageUrl = "https://picsum.photos/id/${it}/128"
                    )
                },
                favoriteList = listOf(0),
                onItemClick = { },
                onRemoveFromFavorite = { },
                onAddToFavorite = { },
                onLoadMore = { }
            )
        } 
    }
}

