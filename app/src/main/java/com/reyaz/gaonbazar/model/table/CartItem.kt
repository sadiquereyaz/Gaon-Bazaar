package com.reyaz.gaonbazar.model.table

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity/*(tableName = "CartItem")*/
data class CartItem(
    @PrimaryKey val itemId: Int,
    val itemCategory: String,
    val itemName: String,
    val itemPrice: Double,
    val itemQuantity: Int,
    @Ignore val imagePath: String,  //@Ignore, indicating that it should not be included in the database schema. This means that Room will not create a corresponding column
    )
