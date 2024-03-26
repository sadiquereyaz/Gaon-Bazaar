package com.reyaz.gaonbazar.screens

import android.content.Context
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align


import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
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



@Composable
fun ItemList( id:String?) {
    var listItem = emptyList<Item>()
    getItemsForCategory(id!!).observe(LocalLifecycleOwner.current,{
        listItem = it;
    })
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(listItem){
            itemViewCard(item = it)

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
                    painter = painterResource(id = R.drawable.cropped),
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

                    Box(
                        modifier = Modifier
                            .align(Alignment.Start)
                            .fillMaxWidth()


                    ) {
                        addButton()
                    }

                }

            }

        }
    }
}@Composable
fun addButton() {
    val isAdd = remember { mutableStateOf(false) }
    var counter = remember { mutableStateOf(0) }

    if (!isAdd.value) {
        Button(
            onClick = {
                isAdd.value = true
                counter.value = 1
            },
            modifier = Modifier.size(100.dp, 40.dp)
        ) {
            Text(text = "ADD", fontSize = 15.sp)
        }
    } else {
        if(counter.value != 0){
            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { counter.value-- },
                    modifier = Modifier.size(30.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_exposure_neg_1_24),
                        modifier = Modifier.size(15.dp),
                        contentDescription = "decrement"
                    )
                }
                Text(
                    text = "${counter.value}",
                    modifier = Modifier.size(20.dp),
                    fontSize = 15.sp
                )
                Button(
                    onClick = { counter.value++ },
                    modifier = Modifier.size(30.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_plus_one_24),
                        modifier = Modifier.size(15.dp),
                        contentDescription = "increment"
                    )
                }
            }
        }else{
            isAdd.value = false

















        }
    }
}
