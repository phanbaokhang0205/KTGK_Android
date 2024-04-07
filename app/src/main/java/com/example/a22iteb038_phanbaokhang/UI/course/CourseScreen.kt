package com.example.a22iteb038_phanbaokhang.UI.course

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.a22iteb038_phanbaokhang.Data.Course
import com.example.a22iteb038_phanbaokhang.UI.composables.ContentBottomAppBar
import com.example.a22iteb038_phanbaokhang.UI.composables.MyAlertDialog
import com.example.a22iteb038_phanbaokhang.UI.composables.MyTopAppBar
import com.example.a22iteb038_phanbaokhang.UI.composables.TheButton
import com.example.a22iteb038_phanbaokhang.UI.composables.UserInput
import com.example.a22iteb038_phanbaokhang.UI.theme._22ITEB038_PhanBaoKhangTheme
import com.example.a22iteb038_phanbaokhang.ViewModel.CourseViewModel

@Composable
fun CourseScreen(
    primeOnScreen: () -> Unit,
    equationOnScreen: () -> Unit,
    courseOnScreen: () -> Unit,
    homeOnScreen: () -> Unit,
    goToAdd: () -> Unit,
    courseViewModel: CourseViewModel = viewModel(),
) {


    Scaffold(
//        Header
        topBar = {
            MyTopAppBar("Course Manager")
        },
//        Footer
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
//        Content
        Column(
            modifier = Modifier
                .padding(innerPadding),
        ) {
            Spacer(modifier = Modifier.height(30.dp))

//          Title Of Course
            Column(modifier = Modifier.weight(0.5f)) {
                TitleOfCourse()
            }
            Spacer(modifier = Modifier.height(25.dp))


//          Course List
            Column(
                modifier = Modifier.weight(5f)
            ) {
                CourseList(
                    courseList = if (courseViewModel.searchText.isNotBlank()) {
                        courseViewModel.searchCourse(courseViewModel.searchText)
                    } else {
                        courseViewModel.courseList
                    }
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

//          Searching & Modify
            Column(
                modifier = Modifier.weight(2f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    UserInput(
                        value = courseViewModel.searchText,
                        onValueChange = { courseViewModel.updateSearch(it) },
                        label = "Searching ...",
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Done
                        ),
                        modifier = Modifier
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    TheButton(
                        buttonName = "Modify",
                        buttonEvent = {
                            goToAdd()
                        },
                        modifier = Modifier
                            .height(60.dp)
                            .width(255.dp),
                        modifierText = Modifier
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))

            }
        }
    }
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


