package com.reyaz.gaonbazar.model

import android.media.Image
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "CartItem")
data class CartItem(
    @PrimaryKey val id: Int,
    val category: String,
    val name: String,
    val price: Double,
    val quantity: Int,
    @Ignore val imagePath: String,  //@Ignore, indicating that it should not be included in the database schema. This means that Room will not create a corresponding column
    )
