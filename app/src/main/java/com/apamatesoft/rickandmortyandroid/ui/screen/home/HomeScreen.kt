package com.apamatesoft.rickandmortyandroid.ui.screen.home

import androidx.compose.runtime.Composable
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.apamatesoft.rickandmortyandroid.ui.screen.home.components.CharacterList
import com.apamatesoft.rickandmortyandroid.ui.theme.RickAndMortyAndroidTheme

@Composable
fun HomeScreen(
    homeModel: HomeModel = hiltViewModel(),
    navController: NavController
) {

    Box(modifier = Modifier.fillMaxSize()) {
        if (homeModel.state.characters.isNotEmpty()) {
            CharacterList(
                characters = homeModel.state.characters,
                onItemClick = {
                    // TODO: Navigate to character details
                },
                onAddToFavorite = {
                    // TODO: Add character to favorite list
                },
                onRemoveFromFavorite = {
                    // TODO: Remove character from favorite list
                }
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


