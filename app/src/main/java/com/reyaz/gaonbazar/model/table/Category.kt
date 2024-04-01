package com.reyaz.gaonbazar.model.table

import androidx.room.PrimaryKey


data class Category(
    @PrimaryKey val categoryId: Int,
    val categoryName: String,
    val categoryImageUrl: String
)


/*

 json format

 items{

   itemId1{
      itemId: 12345
      itemName: "sugar"
      ....
           }

   itemId2{
      itemId: 123442545
      itemName: "oreange"
      ....
           }
      }

*/