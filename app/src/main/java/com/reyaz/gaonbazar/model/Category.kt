package com.reyaz.gaonbazar.model

import androidx.room.Entity

@Entity()
data class Category(
    val id: String,
    val name: String,
    val imageUrl: String
)
