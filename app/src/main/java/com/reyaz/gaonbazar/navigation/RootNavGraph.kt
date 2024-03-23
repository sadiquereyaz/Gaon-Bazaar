package com.reyaz.gaonbazar.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.reyaz.gaonbazar.screens.CategoryScreen

@Composable
fun SetupNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "category",
//        startDestination = MAIN_ROUTE,
        route = "category_route"
    ) {
        composable(route = "category") {
            CategoryScreen(navController = navController)
        }
    }
}