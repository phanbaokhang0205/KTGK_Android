package com.example.a22iteb038_phanbaokhang.UI.composables

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


@Composable
fun UserInput(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        singleLine = true,
        keyboardOptions = keyboardOptions,
        modifier = modifier
    )
}

@Composable
fun TheButton(
    buttonName: String,
    buttonEvent:() -> Unit,
    modifier: Modifier,
    modifierText: Modifier
) {
    Button(
        onClick = buttonEvent,
        modifier = modifier,
    ) {
        Text(text = buttonName,modifier = modifierText)
    }
}


@Composable
fun Menu(
    modifier: Modifier,
    modifierText: Modifier,
    title: String,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = modifierText
        )
    }
}

@Composable
fun ListOfMenu(
    modifierHome: Modifier,
    modifierPrime: Modifier,
    modifierEquation: Modifier,
    modifierCourse: Modifier
) {
    Menu(
        modifier = modifierHome,
        modifierText = Modifier,
        title = "Home"
    )

    Menu(
        modifier = modifierPrime,
        modifierText = Modifier,
        title = "Prime"
    )

    Menu(
        modifier = modifierEquation,
        modifierText = Modifier,
        title = "Equation"
    )

    Menu(
        modifier = modifierCourse,
        modifierText = Modifier,
        title = "Courses"
    )
}

//Top app bar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    title: String,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xff00ADB5),
            titleContentColor = Color.White,
        ),
        title = {
            Text(
                text = title,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
        },
        modifier = modifier
    )
}


//Content Bottom App Bar
@Composable
fun ContentBottomAppBar(
    modifier: Modifier,
    primeOnScreen: () -> Unit,
    equationOnScreen: () -> Unit,
    courseOnScreen: () -> Unit,
    homeOnScreen: () -> Unit,
) {
    Row(
        modifier = modifier
    ) {
        ListOfMenu(
            modifierHome = Modifier
                .fillMaxHeight()
                .weight(1f)
                .clickable {
                    homeOnScreen()
                },
            modifierPrime = Modifier
                .fillMaxHeight()
                .weight(1f)
                .clickable {
                    primeOnScreen()
                },
            modifierEquation = Modifier
                .fillMaxHeight()
                .weight(1f)
                .clickable {
                    equationOnScreen()
                },
            modifierCourse = Modifier
                .fillMaxHeight()
                .weight(1f)
                .clickable {
                    courseOnScreen()
                },
        )
    }
}

//Alert Dialog
@Composable
fun MyAlertDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
) {
    AlertDialog(
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}
