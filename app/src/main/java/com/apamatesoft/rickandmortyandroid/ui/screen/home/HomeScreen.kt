package com.apamatesoft.rickandmortyandroid.ui.screen.home

import androidx.compose.runtime.Composable
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.apamatesoft.rickandmortyandroid.ui.screen.home.components.HomeContent
import com.apamatesoft.rickandmortyandroid.ui.theme.RickAndMortyAndroidTheme

@Composable
fun HomeScreen(
    homeModel: HomeModel = hiltViewModel(),
    navController: NavController
) {

    LaunchedEffect(true) {
        homeModel.onCreate()
    }

    HomeContent(
        state = homeModel.state,
        onItemClick = { navController.navigate("CHARACTER_DETAILS") },
        onAddToFavorite = {  },
        onRemoveFromFavorite = {} ,
        onLoadMore = {
            homeModel.loadMoreCharacters()
        },
        onRetry = { homeModel.characterRequest() }
    )

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


