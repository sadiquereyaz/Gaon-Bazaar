package com.reyaz.gaonbazar.model.table

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Order(
 @PrimaryKey
 val orderId: Int,
 val status: Int, // convention defined in "Constant"
 val date: Date,
 val phoneNo:Int,
 val totalPrice: Int,
 val item: Item
)