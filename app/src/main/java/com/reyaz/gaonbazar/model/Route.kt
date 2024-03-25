package com.reyaz.gaonbazar.model

sealed class Route(val route:String) {
    object Home:Route("category")
    object Item:Route("image_screen")
}