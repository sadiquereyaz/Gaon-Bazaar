package com.reyaz.gaonbazar.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.reyaz.gaonbazar.R
import com.reyaz.gaonbazar.model.BottomBarItem
import com.reyaz.gaonbazar.model.Constant.CATEGORY
import com.reyaz.gaonbazar.model.Constant.ORDER
import com.reyaz.gaonbazar.model.Constant.SELLER
import com.reyaz.gaonbazar.navigation.BottomNavGraph


@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController(),
) {
    val bottomBarItem = remember { createBottomBarItems() }
    Scaffold(
        bottomBar = {
            BottomBarView(
                bottomBarItems = bottomBarItem,
                navController = navController
            )
        }
    ) {
        it
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBarView(
    bottomBarItems: List<BottomBarItem>,
    navController: NavHostController
) {
    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = bottomBarItems.any { it.title == currentDestination?.route }

    if (bottomBarDestination) {
        NavigationBar {
            bottomBarItems.forEachIndexed { index, bottomBarItem ->

                val isSelected = currentDestination?.hierarchy?.any {
                    it.route == bottomBarItem.title
                } == true

                NavigationBarItem(
                    onClick = {
                        selectedItemIndex = index
                        navController.navigate(bottomBarItem.title) {
                            popUpTo(navController.graph.findStartDestination().id)
                            launchSingleTop = true
                        }
                    },
                    selected = currentDestination?.hierarchy?.any {
                        it.route == bottomBarItem.title
                    } == true,
                    icon = {
                        if (isSelected) {
                            Icon(
                                painterResource(id = bottomBarItem.selectedIcon),
                                contentDescription = bottomBarItem.title,
                                tint = MaterialTheme.colorScheme.primary
//                                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                            )
//                            Image(
//                                imageVector = bottomBarItem.selectedIcon,
//                                contentDescription = bottomBarItem.title,
//                                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
//                            )
                        } else {
                            Icon(
                                painterResource(id = bottomBarItem.unSelectedIcon),
                                contentDescription = bottomBarItem.title,
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    },
                    label = { Text(text = bottomBarItem.title, fontWeight = FontWeight.Bold) }
                )

            }
        }
    }
}


fun createBottomBarItems(): List<BottomBarItem> {
    return listOf(
        BottomBarItem(
            title = CATEGORY,
            selectedIcon = R.drawable.category_filled,
            unSelectedIcon = R.drawable.category_outlined
        ),
        BottomBarItem(
            title = ORDER,
            selectedIcon = R.drawable.order_filled,
            unSelectedIcon = R.drawable.order_outlined
        ),
        BottomBarItem(
            title = SELLER,
            selectedIcon = R.drawable.shop_fill,
            unSelectedIcon = R.drawable.shop_out
        ),
    )
}

