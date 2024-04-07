package com.example.a22iteb038_phanbaokhang.UI.equation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a22iteb038_phanbaokhang.UI.composables.ContentBottomAppBar
import com.example.a22iteb038_phanbaokhang.UI.composables.MyTopAppBar
import com.example.a22iteb038_phanbaokhang.UI.composables.TheButton
import com.example.a22iteb038_phanbaokhang.UI.theme._22ITEB038_PhanBaoKhangTheme


@Composable
fun EquationScreen(
    primeOnScreen:() -> Unit,
    equationOnScreen:() -> Unit,
    courseOnScreen:() -> Unit,
    homeOnScreen:() -> Unit,
) {
    var a by remember {
        mutableStateOf("")
    }
    val numberA = a.toDoubleOrNull() ?: 0.0
    var b by remember {
        mutableStateOf("")
    }
    val numberB = b.toDoubleOrNull() ?: 0.0

    var message by remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            MyTopAppBar("Equation")
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFF00ADB5),
                contentColor = Color.White,
            ) {
                ContentBottomAppBar(
                    modifier = Modifier.weight(4f),
                    primeOnScreen = primeOnScreen,
                    equationOnScreen = equationOnScreen,
                    courseOnScreen = courseOnScreen,
                    homeOnScreen = homeOnScreen
                )
            }

        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Solve the equation: ax+b = 0",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(30.dp))

            OutlinedTextField(
                value = a,
                onValueChange = {a = it},
                label = { Text(text = "Input a:")},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier

            )

            Spacer(modifier = Modifier.height(30.dp))

            OutlinedTextField(
                value = b,
                onValueChange = {b = it},
                label = { Text(text = "Input a:")},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(30.dp))

            Row {


                TheButton(
                    buttonName = "Solve",
                    buttonEvent = {
                        message = if (numberA == 0.0) {
                            "The equation has NO solution!"
                        } else {
                            val x = -numberB/numberA
                            val roundedNumber = String.format("%.2f",x).toDouble()
                            "Your equation: ${numberA}X + $numberB = 0" +
                                    "\nThe equation has a solution x = $roundedNumber"
                        }
                    },
                    modifier = Modifier,
                    modifierText = Modifier
                )
                Spacer(modifier = Modifier.width(15.dp))
                TheButton(
                    buttonName = "Reset",
                    buttonEvent = {
                        a = ""
                        b = ""
                    },
                    modifier = Modifier,
                    modifierText = Modifier
                )
            }
            Spacer(modifier = Modifier.width(30.dp))

            Text(
                message,
                fontWeight = FontWeight.Bold,
                fontSize = 23.sp
            )

        }
    }


}

@Preview(showBackground = true)
@Composable
fun AddCoursePreview() {
    _22ITEB038_PhanBaoKhangTheme {
        EquationScreen(
            primeOnScreen = {},
            homeOnScreen = {},
            courseOnScreen = {},
            equationOnScreen = {},
        )
    }
}