package com.reyaz.gaonbazar.screens


import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.reyaz.gaonbazar.ui.theme.md_theme_dark_orderStatus
import com.reyaz.gaonbazar.ui.theme.md_theme_light_orderStatus

@Composable
fun OrderScreen(
    navController: NavController
) {
    val context = LocalContext.current
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
    val tabTitles = listOf("Ongoing", "History")
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.primary)
                .padding(start = 16.dp, top = 16.dp, bottom = 16.dp),
            contentAlignment = Alignment.TopStart

        ) {
            Column {
                Text(text = "Orders", fontSize = 24.sp, fontWeight = FontWeight.Bold,
                     color = MaterialTheme.colorScheme.onPrimary)
            }
        }

        TabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(text = title, fontWeight = FontWeight.Bold) }
                )
            }
        }
//
//        when (selectedTabIndex) {
//            0 -> TabContent(cardContent =) {
//
//            }
//        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            elevation = CardDefaults.cardElevation(4.dp),


            ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Mobile No. 9506198939",
                    fontStyle = FontStyle.Italic
                )
                Spacer(Modifier.height(10.dp))
                EachItemRow("item Name", 125)
                EachItemRow()
                EachItemRow()
//                val totalPrice = calTotalPrice()
//                val deliveryCharge = calDeliveryCharge()
                EachItemRow(name = "Delivery Charge", 10)

                Spacer(modifier = Modifier.height(4.dp))
                EachItemRow("Grand Total", 500, fontWeight = FontWeight.Bold)


                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Status: On the Way",
                        color = if (isSystemInDarkTheme()) {
                            md_theme_dark_orderStatus
                        } else {
                            md_theme_light_orderStatus
                        },
                        fontWeight = FontWeight.Bold
                    )
                }

            }
        }

    }


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Button(
            modifier = Modifier.padding(bottom = 100.dp),
            onClick = {
                val u = Uri.parse("tel:9506198939")

                // Create the intent and set the data for the
                // intent as the phone number.
                val i = Intent(Intent.ACTION_DIAL, u)
                try {

                    // Launch the Phone app's dialer with a phone
                    // number to dial a call.
                    context.startActivity(i)
                } catch (s: SecurityException) {

                    // show() method display the toast with
                    // exception message.
                    Toast.makeText(context, "An error occurred", Toast.LENGTH_LONG)
                        .show()
                }
            },
            shape = RoundedCornerShape(5.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Default.Phone, contentDescription = null)
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = "Call Seller"
                )
            }
        }
    }
}

@Composable
private fun EachItemRow(
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OrderScreenPreview() {
    val navController = rememberNavController()
    OrderScreen(navController = navController)
}