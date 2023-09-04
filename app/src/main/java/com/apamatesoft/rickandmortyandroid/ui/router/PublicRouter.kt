package com.apamatesoft.rickandmortyandroid.ui.router

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.apamatesoft.rickandmortyandroid.ui.screen.characterdetail.CharacterDetailsScreen
import com.apamatesoft.rickandmortyandroid.ui.screen.home.HomeScreen

fun NavGraphBuilder.publicGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = "HOME",
        route = "public"
    ) {
        composable("HOME") {
            HomeScreen(
                navController = navController
            )
        }
        composable("CHARACTER_DETAILS") {
            CharacterDetailsScreen()
        }
    }
}