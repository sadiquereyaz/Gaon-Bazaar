package com.reyaz.gaonbazar.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SellerScreen(
    navController: NavController
) {

    Text(
        modifier = Modifier.padding(16.dp),
        text = "Seller",
        style = MaterialTheme.typography.headlineLarge,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        color = Color(MaterialTheme.colorScheme.onPrimary.toArgb())
    )
}