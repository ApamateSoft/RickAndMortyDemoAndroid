package com.apamatesoft.rickandmortyandroid

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.apamatesoft.rickandmortyandroid.ui.router.Router
import com.apamatesoft.rickandmortyandroid.ui.theme.RickAndMortyAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            RickAndMortyAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Router(navController = navController)
                }
            }
        }
    }

}

//@Composable
//fun NavigationBottomBar(
//    navController: NavController
//) {
//
//    var selectedItem by remember { mutableStateOf(0) }
//    val items = listOf("Personajes", "Favoritos")
//
//    NavigationBar {
//        items.forEachIndexed { index, item ->
//            NavigationBarItem(
//                icon = { Icon(Icons.Filled.Favorite, contentDescription = item) },
//                label = { Text(item) },
//                selected = selectedItem == index,
//                onClick = {
//                    selectedItem = index
//                    when (index) {
//                        0 -> navController.navigate("HOME")
//                        else -> navController.navigate("FAVORITES")
//                    }
//                }
//            )
//        }
//    }
//
//}
//
