package com.apamatesoft.rickandmortyandroid.ui.screen.home

import androidx.compose.runtime.Composable
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.apamatesoft.rickandmortyandroid.R
import com.apamatesoft.rickandmortyandroid.ui.screen.home.components.HomeContent
import com.apamatesoft.rickandmortyandroid.ui.theme.RickAndMortyAndroidTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    navController: NavController
) {

    LaunchedEffect(true) {
        homeViewModel.onCreate()
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Rick and Morty") },
                actions = {
                    IconButton(onClick = { navController.navigate("FAVORITES") }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_favorite_fill),
                            contentDescription = null,
                            tint = Color.Red
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(Modifier.padding(paddingValues)) {
            HomeContent(
                state = homeViewModel.state,
                onItemClick = { navController.navigate("CHARACTER_DETAILS") },
                onAddToFavorite = { homeViewModel.addToFavorite(it.id) },
                onRemoveFromFavorite = { homeViewModel.removeFromFavorite(it.id) },
                onLoadMore = { homeViewModel.loadMoreCharacters() },
                onRetry = { homeViewModel.characterRequest() }
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
private fun PreviewHomeScreen() {
    RickAndMortyAndroidTheme {
        Surface {
            HomeScreen(navController = rememberNavController())
        }
    }
}


