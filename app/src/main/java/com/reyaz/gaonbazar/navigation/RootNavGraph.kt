package com.reyaz.gaonbazar.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.reyaz.gaonbazar.model.Constant.CATEGORY
import com.reyaz.gaonbazar.model.Constant.MAIN
import com.reyaz.gaonbazar.model.Constant.ORDER
import com.reyaz.gaonbazar.model.Constant.SELLER
import com.reyaz.gaonbazar.screens.CategoryScreen
import com.reyaz.gaonbazar.screens.MainScreen
import com.reyaz.gaonbazar.screens.OrderScreen
import com.reyaz.gaonbazar.screens.SellerScreen

@Composable
fun SetupNavigation(
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MAIN,
        route = "main_route"

    ) {
        composable(route = MAIN) {
            MainScreen()
        }
    }
}
