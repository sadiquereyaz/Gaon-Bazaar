package com.reyaz.gaonbazar.model.table

import androidx.room.PrimaryKey

data class Item(
    @PrimaryKey val itemId: Int,
    val itemName: String,
    val itemPrice: Int,
    val itemImageUrl:String,
//    val available: Int      // convention in constant file
)