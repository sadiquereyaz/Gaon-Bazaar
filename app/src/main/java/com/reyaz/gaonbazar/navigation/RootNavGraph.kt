package com.reyaz.gaonbazar.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.reyaz.gaonbazar.model.Constant.MAIN
import com.reyaz.gaonbazar.screens.CategoryScreen
import com.reyaz.gaonbazar.screens.MainScreen

@Composable
fun SetupNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MAIN,
//        startDestination = MAIN_ROUTE,
//        route = "category_route"
    ) {
        composable(route = MAIN) {
            MainScreen()
        }
    }
}