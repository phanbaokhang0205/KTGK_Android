package com.example.a22IT_EB038_phan_bao_khang.UI.prime

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.BottomAppBar
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.a22IT_EB038_phan_bao_khang.UI.composables.ContentBottomAppBar
import com.example.a22IT_EB038_phan_bao_khang.UI.composables.MyTopAppBar
import com.example.a22IT_EB038_phan_bao_khang.UI.composables.TheButton
import com.example.a22IT_EB038_phan_bao_khang.UI.composables.UserInput

@Composable
fun PrimeNumberScreen(
    primeOnScreen:() -> Unit,
    equationOnScreen:() -> Unit,
    courseOnScreen:() -> Unit,
    homeOnScreen:() -> Unit,
) {

    var inputValue by remember {
        mutableStateOf("")
    }
    val input = inputValue.toIntOrNull() ?: 0

    var message by remember {
        mutableStateOf("")
    }


    Scaffold(
        topBar = {
            MyTopAppBar("Prime Number")
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
            UserInput(
                value = inputValue,
                onValueChange = { inputValue = it },
                label = "Your number:",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier
            )

            Row {
                TheButton(
                    buttonName = "Check",
                    buttonEvent = {
                        message = if (input == 0) {
                            "O is NOT a prime number"
                        } else {
                            if (checkPrime(input)) {
                                "$input is a prime number."
                            } else {
                                "$input is NOT a prime number."
                            }
                        }
                    },
                    modifier = Modifier,
                    modifierText = Modifier
                )
                Spacer(modifier = Modifier.width(15.dp))
                TheButton(
                    buttonName = "Reset",
                    buttonEvent = {
                                  inputValue = ""
                                  },
                    modifier = Modifier,
                    modifierText = Modifier
                )
            }
            Text(message)


        }
    }
}

private fun checkPrime(numb: Int): Boolean {
    for (i in 2..numb / 2) {
        if (numb % i == 0) {
            return false
        }
    }
    return true
}


