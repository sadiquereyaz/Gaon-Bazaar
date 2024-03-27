package com.reyaz.gaonbazar.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.reyaz.gaonbazar.components.CategoryItem
import com.reyaz.gaonbazar.model.Category
import com.reyaz.gaonbazar.model.Item
import com.reyaz.gaonbazar.R
import com.reyaz.gaonbazar.model.Route
import com.reyaz.gaonbazar.model.writeCategory

@Composable
fun CategoryScreen(
    navController: NavController
) {
    val categories by getCategories().observeAsState(initial = emptyList())


    Column(Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                 Image(
                     modifier = Modifier.size(60.dp).padding(start = 16.dp),
                     painter = painterResource(R.drawable.logo),
                     contentScale = ContentScale.Crop,
                     contentDescription = null,
                     colorFilter = ColorFilter.tint(Color.White)
                 )
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = "Gaon Bazaar",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp,
                    color = Color(MaterialTheme.colorScheme.onPrimary.toArgb())
                )
            }
        }


         Text(
             text = "Categories",
             modifier = Modifier
                 .padding(top = 24.dp)
                 .fillMaxWidth(),
             fontSize = 24.sp,
             textAlign = TextAlign.Center

         )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            items(categories) { category ->
                CategoryItem(category = category) {
                    navController.navigate(Route.Item.route+"/${category.id}")
                }
            }
        }
    }


}

@Composable
fun ItemList(categoryId: String) {
    val items by getItemsForCategory(categoryId).observeAsState(initial = emptyList())

    // Display items in a list or grid
}

fun getCategories(): LiveData<List<Category>> {

    val dummyCategoryList = listOf(
        Category(
            "1",
            "Fruits",
            "https://i.ytimg.com/vi/a7zhK5yCI0Y/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB0dHONrAHWv7hZuhwlzcq-Y9SJtg"
        ),
        Category(
            "2",
            "Vegetables",
            "https://i.ytimg.com/vi/xoOecJZ2Q-0/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLACQeTcHm87pM_okEDBQEXrLp7WDw"
        ),
        Category(
            "3",
            "Dairy",
            "https://i.ytimg.com/vi/ktOWiLx83bQ/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLAEke-Q-UD1CAp8hwO-8rY_32bMXw"
        )
    )
    writeCategory(dummyCategoryList)
    return MutableLiveData(dummyCategoryList)
}

fun getItemsForCategory(categoryId: String): LiveData<List<Item>> {
    // Fetch items for the given category from Firebase Firestore and return as LiveData
    val dummyItemList = when (categoryId) {
        "1" -> listOf(
            Item("101", "Apple", 1.99),
            Item("102", "Banana", 0.99),
            Item("103", "Orange", 2.49)
        )

        "2" -> listOf(
            Item("201", "Carrot", 0.79),
            Item("202", "Broccoli", 1.49),
            Item("203", "Tomato", 0.69)
        )

        "3" -> listOf(
            Item("301", "Milk", 2.99),
            Item("302", "Cheese", 3.49),
            Item("303", "Yogurt", 1.99)
        )

        else -> emptyList()
    }
    return MutableLiveData(dummyItemList)
}

@Preview(showSystemUi = true)
@Composable
fun CategoryScreenPreview() {
    val navController = rememberNavController()
    val categories = listOf(
        Category(
            "1",
            "Fruits",
            "https://i.ytimg.com/vi/a7zhK5yCI0Y/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLB0dHONrAHWv7hZuhwlzcq-Y9SJtg"
        ),
        Category(
            "2",
            "Vegetables",
            "https://i.ytimg.com/vi/xoOecJZ2Q-0/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLACQeTcHm87pM_okEDBQEXrLp7WDw"
        ),
        Category(
            "3",
            "Dairy",
            "https://i.ytimg.com/vi/ktOWiLx83bQ/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLAEke-Q-UD1CAp8hwO-8rY_32bMXw"
        )
    )

    CategoryScreen(navController = navController)
}

