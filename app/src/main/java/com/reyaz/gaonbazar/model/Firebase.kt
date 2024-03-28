package com.reyaz.gaonbazar.model

import android.util.Log
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

private lateinit var database: DatabaseReference
private lateinit var category:ValueEventListener
fun writeCategory(categories:List<Category>){
    database = Firebase.database.reference
    for (category in categories){
        database.push().setValue(category)
    }

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
