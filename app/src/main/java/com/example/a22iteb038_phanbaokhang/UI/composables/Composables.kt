package com.example.a22IT_EB038_phan_bao_khang.UI.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.a22IT_EB038_phan_bao_khang.Data.Course
import com.example.a22IT_EB038_phan_bao_khang.ViewModel.CourseViewModel


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
fun ListOfMenu(
    modifierHome: Modifier,
    modifierPrime: Modifier,
    modifierEquation: Modifier,
    modifierCourse: Modifier
) {
    Box(
        modifier = modifierHome,
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = null
        )
    }

    Box(
        modifier = modifierEquation,
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = Icons.Filled.Numbers,
            contentDescription = null
        )
    }

    Box(
        modifier = modifierPrime,
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = Icons.Default.Calculate,
            contentDescription = null
        )
    }

    Box(
        modifier = modifierCourse,
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = Icons.Default.Book,
            contentDescription = null
        )
    }
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


@Composable
fun TitleOfCourse() {
    Row(
        modifier = Modifier
            .height(46.dp)
            .background(
                color = Color(0xff00ADB5),
                shape = RoundedCornerShape(
                    topStart = 26.dp, topEnd = 26.dp
                ),
            ),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Text(
            text = "Mã",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f),
        )
        Text(
            text = "Tên",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1.8f)
        )
        Text(
            text = "Số tín chỉ",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1.2f)
        )
        Text(
            text = "Học kỳ",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun CourseList(
    courseList: MutableList<Course>,
) {

    LazyColumn {
        items(courseList) { course ->
            CourseItem(course = course, modifier = Modifier.padding(horizontal = 5.dp))
        }
    }
}

@Composable
fun CourseItem(
    course: Course,
    modifier: Modifier,
    courseViewModel: CourseViewModel = viewModel()
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    var showDialogDelete by remember { mutableStateOf(false) }
    var showDialogUpdate by remember { mutableStateOf(false) }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(start = 5.dp, end = 5.dp)
            .background(
                color = Color(0xFF6AD4DD),
                shape = RoundedCornerShape(
                    bottomStart = 12.dp, topEnd = 12.dp
                ),
            )
            .clickable {
                expanded = !expanded
            },
    ) {
        Row(
            modifier = Modifier
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = course.courseID,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f),
            )
            Text(
                text = course.courseName,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1.8f)
            )
            Text(
                text = course.courseCredit,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1.2f)
            )
            Text(
                text = course.semester,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
        }
        if (expanded) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {

//                Update Course
                IconButton(onClick = {
                    showDialogUpdate = true
                }) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Delete Icon",
                        tint = Color.Green
                    )
                }
                if (showDialogUpdate) {
                    MyAlertDialog(
                        onDismissRequest = { showDialogUpdate = false },
                        onConfirmation = {
                            courseViewModel.updateCourse(course.courseID, context)
                            showDialogUpdate = false
                        },
                        dialogTitle = "Do you want to update it?",
                        dialogText = ""
                    )
                }

//                Delete Course
                IconButton(onClick = {
                    showDialogDelete = true
                }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete Icon",
                        tint = Color.Red
                    )
                }

                if (showDialogDelete) {
                    MyAlertDialog(
                        onDismissRequest = { showDialogDelete = false },
                        onConfirmation = {
                            courseViewModel.removeCourse(course.courseID, context)
                            showDialogDelete = false
                        },
                        dialogTitle = "Do you want to delete it?",
                        dialogText = ""
                    )
                }
            }
        }
    }

    Spacer(modifier = Modifier.height(15.dp))
}