package com.apamatesoft.rickandmortyandroid.ui.screen.home

import androidx.compose.runtime.Composable

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.apamatesoft.rickandmortyandroid.ui.theme.RickAndMortyAndroidTheme
@Composable
fun HomeScreen(
    homeModel: HomeModel = hiltViewModel(),
    navController: NavController
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.weight(1f))

        Text("HomeScreen")

        Spacer(modifier = Modifier.weight(1f))

        Button(onClick = { navController.navigate("CHARACTER_DETAILS") }) {
            Text(text = "TO CHARACTER DETAILS")
        }

        Spacer(modifier = Modifier.weight(1f))

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


