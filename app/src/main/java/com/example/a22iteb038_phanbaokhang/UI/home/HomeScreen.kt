package com.example.a22iteb038_phanbaokhang.UI.home

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    primeOnScreen:() -> Unit,
    equationOnScreen:() -> Unit,
    courseOnScreen:() -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Box(
            modifier = Modifier
                .width(320.dp)
                .height(100.dp)
                .border(color = Color.Black, width = 2.dp),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "My Application",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
        }

        Column(
            modifier = Modifier
                .width(320.dp)
                .height(300.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .border(
                        color = Color.Black,
                        width = 2.dp,
                        shape = RoundedCornerShape(
                            bottomEnd = 12.dp, topStart = 12.dp
                        )
                    )
                    .clickable {
                        primeOnScreen()
                    },
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Prime Number",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .border(
                        color = Color.Black, width = 2.dp, shape = RoundedCornerShape(
                            bottomEnd = 12.dp, topStart = 12.dp
                        )
                    )
                    .clickable {
                        equationOnScreen()
                    },
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Equation",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .border(
                        color = Color.Black, width = 2.dp, shape = RoundedCornerShape(
                            bottomEnd = 12.dp, topStart = 12.dp
                        )
                    )
                    .clickable {
                        courseOnScreen()
                    },
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Course Manager",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
            }
        }

    }
}