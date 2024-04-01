package com.reyaz.gaonbazar.model

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.reyaz.gaonbazar.model.table.Category

private lateinit var database: DatabaseReference
private lateinit var category:ValueEventListener
@Composable
fun writeCategory(){
    val categories = listOf(
        Category(

            "Fruits",
            "https://i.ytimg.com/vi/a7zhK5yCI0Y/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB0dHONrAHWv7hZuhwlzcq-Y9SJtg"
        ),
        Category(

            "Vegetables",
            "https://i.ytimg.com/vi/xoOecJZ2Q-0/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLACQeTcHm87pM_okEDBQEXrLp7WDw"
        ),
        Category(

            "Dairy",
            "https://i.ytimg.com/vi/ktOWiLx83bQ/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLAEke-Q-UD1CAp8hwO-8rY_32bMXw"
        )
    )
    database = Firebase.database.reference
    for (category in categories){
        database.child("Category").push().setValue(category)
    }
    Toast.makeText(LocalContext.current, "${categories.size}", Toast.LENGTH_SHORT).show()
}
fun readCategoryItem(callback: (List<Category>) -> Unit) {
    database = Firebase.database.getReference("Category")
    database.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            val categoryList = mutableListOf<Category>()
            for (postSnapShot in snapshot.children) {
                val category = postSnapShot.getValue<Category>()
                category?.let {
                    categoryList.add(it)
                }
            }
            callback(categoryList) // Pass the result using the callback
        }

        override fun onCancelled(error: DatabaseError) {
            // Handle onCancelled if needed
        }
    })
}
