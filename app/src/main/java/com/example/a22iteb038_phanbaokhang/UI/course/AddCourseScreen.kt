package com.example.a22iteb038_phanbaokhang.UI.course

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.a22iteb038_phanbaokhang.Data.Course
import com.example.a22iteb038_phanbaokhang.UI.composables.ContentBottomAppBar
import com.example.a22iteb038_phanbaokhang.UI.composables.MyTopAppBar
import com.example.a22iteb038_phanbaokhang.UI.composables.TheButton
import com.example.a22iteb038_phanbaokhang.UI.composables.UserInput
import com.example.a22iteb038_phanbaokhang.UI.theme._22ITEB038_PhanBaoKhangTheme
import com.example.a22iteb038_phanbaokhang.ViewModel.CourseViewModel

@Composable
fun AddCourseScreen(
    primeOnScreen: () -> Unit,
    equationOnScreen: () -> Unit,
    courseOnScreen: () -> Unit,
    homeOnScreen: () -> Unit,
    courseViewModel: CourseViewModel = viewModel(),
) {

    val courseUiState by courseViewModel.uiState.collectAsState()
    val context = LocalContext.current

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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))

            Column(modifier = Modifier.weight(0.5f)) {
                TitleOfCourse()
            }

//          Course List
            Column(
                modifier = Modifier.weight(2.5f)
            ) {
                CourseList(
                    courseList = courseViewModel.courseList
                )
            }
            Spacer(modifier = Modifier.height(30.dp))

//            User Input
            UserInput(
                value = courseUiState.courseID,
                onValueChange = { courseViewModel.updateID(it) },
                label = "Course ID:",
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(20.dp))
            UserInput(
                value = courseUiState.courseName,
                onValueChange = { courseViewModel.updateName(it) },
                label = "Course Name:",
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.wrapContentSize(),

                ) {
                UserInput(
                    value = courseUiState.courseCredit,
                    onValueChange = { courseViewModel.updateCredit(it) },
                    label = "Credit:",
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Number
                    ),
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(15.dp))
                UserInput(
                    value = courseUiState.semester,
                    onValueChange = { courseViewModel.updateSemester(it) },
                    label = "Semester:",
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done,
                        keyboardType = KeyboardType.Number
                    ),
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))

//            Button Add
            TheButton(
                buttonName = "Add to List",
                buttonEvent = {
                    courseViewModel.addCourse(context)
                },
                modifier = Modifier.clip(RoundedCornerShape(100)),
                modifierText = Modifier
            )
            Spacer(modifier = Modifier.height(15.dp))


        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddCoursePreview() {
    _22ITEB038_PhanBaoKhangTheme {
        AddCourseScreen(
            primeOnScreen = {},
            homeOnScreen = {},
            courseOnScreen = {},
            equationOnScreen = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CoursePreview() {
    _22ITEB038_PhanBaoKhangTheme {
        CourseScreen(
            primeOnScreen = {},
            homeOnScreen = {},
            courseOnScreen = {},
            equationOnScreen = {},
            goToAdd = {}
        )
    }
}