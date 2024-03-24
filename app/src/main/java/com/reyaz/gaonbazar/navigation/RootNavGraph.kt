package com.reyaz.gaonbazar.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.reyaz.gaonbazar.model.Route
import com.reyaz.gaonbazar.screens.CategoryScreen
import com.reyaz.gaonbazar.screens.ItemList

@Composable
fun SetupNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "category"
//        startDestination = MAIN_ROUTE,

    ) {
        composable(route = "category") {
            CategoryScreen(navController = navController)
        }
        composable(route=Route.Item.route+"/{id}"){
            val Id = it.arguments?.getString("id")
            ItemList(Id)
        }
    }
}