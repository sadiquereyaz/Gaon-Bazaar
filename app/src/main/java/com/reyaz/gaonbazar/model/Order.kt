package com.reyaz.gaonbazar.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Order(
 @PrimaryKey
 val orderId: Int,
 val status: String,
 val date: String,
 val Item: Item
)
