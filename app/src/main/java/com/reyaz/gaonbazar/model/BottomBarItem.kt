package com.reyaz.gaonbazar.model

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomBarItem(
    val title: String,
    val selectedIcon : ImageVector,
    val unSelectedIcon: ImageVector
)