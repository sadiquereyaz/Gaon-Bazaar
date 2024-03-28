package com.reyaz.gaonbazar.screens

import android.content.Context
import android.media.Image
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import coil.compose.rememberAsyncImagePainter
import com.reyaz.gaonbazar.MainActivity
import com.reyaz.gaonbazar.R
import com.reyaz.gaonbazar.model.Item
import com.reyaz.gaonbazar.model.readCategoryItem


@Composable
fun ItemList( name:String?) {
//   val readItem= readCategoryItem()
//    Toast.makeText(LocalContext.current, "$readItem", Toast.LENGTH_LONG).show()
    var listItem = emptyList<Item>()
    getItemsForCategory(name!!).observe(LocalLifecycleOwner.current,{
        listItem = it;
    })
    
    Column(horizontalAlignment = Alignment.Start) {
        tabList(id = name)
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(listItem){
                itemViewCard(item = it)

            }

        }

    }



}


@Composable
fun itemViewCard(item: Item) {



    Spacer(modifier = Modifier.height(8.dp))
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(4.dp))
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalArrangement = Arrangement.Top
            ) {
                Image(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .size(60.dp, 60.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    painter = painterResource(id = R.drawable.logo),
                    alignment = Alignment.CenterStart,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = item.name,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Spacer(modifier = Modifier.width(16.dp))

                Column(modifier = Modifier.padding(3.dp),
                    verticalArrangement = Arrangement.SpaceAround) {
                    Text(
                        text = item.price.toString(),
                        modifier = Modifier
                            .align(Alignment.Start)
                            .padding(0.dp, 0.dp, 12.dp, 0.dp),
                        color = Color.Black,
                    )

                    Box(contentAlignment = Alignment.BottomEnd,
                        modifier = Modifier
                            .fillMaxWidth(0.4f)


                    ) {
                        addButton()
                    }

                }

            }

        }
    }
}
@Composable
fun addButton() {
    val isAdd = remember { mutableStateOf(false) }
    var counter = remember { mutableStateOf(0) }

    if (!isAdd.value) {
        Text(text = "ADD",
            modifier = Modifier
                .clickable {
                    isAdd.value = true
                    counter.value = 1

                }
                .fillMaxSize(1f))
    } else {
        if(counter.value != 0){
            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .background(Color.DarkGray)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.Right
            ) {
                Text(text = "-",
                    fontSize = 20.sp,
                    modifier = Modifier.clickable { counter.value--; })
                Text(
                    text = "${counter.value}",
                    fontSize = 20.sp
                )
                Text(text = "+",
                    fontSize = 20.sp,
                    modifier = Modifier.clickable { counter.value++; })
            }
        }else{
            isAdd.value = false
        }
    }
}

@Composable
fun tabList(id: String?) {
    val tabItems = remember { mutableStateListOf<Item>() }

    getItemsForCategory(id!!).observe(LocalLifecycleOwner.current) { items ->
        tabItems.clear()
        tabItems.addAll(items)
    }

    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(tabItems) { item ->
            tabCard(item)
        }
    }
}

@Composable
fun tabCard(tabItem: Item) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .clip(RoundedCornerShape(4.dp))
    ) {
        Box(
            modifier = Modifier
                .background(Color.Gray)
                .padding(16.dp)
        ) {
            Text(
                text = tabItem.name,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold)
        }
    }
}
