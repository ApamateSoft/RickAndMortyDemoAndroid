package com.apamatesoft.rickandmortyandroid.ui.router


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.apamatesoft.rickandmortyandroid.ui.router.publicGraph

@Composable
fun Router(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = "public"
    ) {
        publicGraph(navController)
    }
}