package com.reyaz.gaonbazar.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EachOrderItem(
    name: String = "item_name",
    price: Int = 25,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = name,
            fontWeight = fontWeight,
            fontSize = 16.sp,
//                        modifier = Modifier.fillMaxWidth(),
        )
        Text(
            modifier = Modifier.weight(1f),
            text = "$price Rs",
            textAlign = TextAlign.End,
            fontWeight = fontWeight,
            fontSize = 16.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EachOrderItemPreview() {
    EachOrderItem(
        name = "Sample Item",
        price = 100,
        fontWeight = FontWeight.Bold,
    )
}