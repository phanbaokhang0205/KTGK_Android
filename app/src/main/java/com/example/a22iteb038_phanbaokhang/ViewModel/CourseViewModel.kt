package com.example.a22IT_EB038_phan_bao_khang.ViewModel

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.a22IT_EB038_phan_bao_khang.Data.Course
import com.example.a22IT_EB038_phan_bao_khang.Data.ListCourse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CourseViewModel : ViewModel() {
    private var _uiState = MutableStateFlow(Course())
    val uiState: StateFlow<Course> = _uiState.asStateFlow()

    //    Course List
    val courseList = mutableStateListOf<Course>()


    init {
        courseList.addAll(ListCourse.courses)
    }

    //    Update User inputs to UI
    fun updateID(value: String) {
        _uiState.value = _uiState.value.copy(
            courseID = value
        )
    }

    fun updateName(value: String) {
        _uiState.value = _uiState.value.copy(
            courseName = value
        )
    }

    fun updateCredit(value: String) {
        _uiState.value = _uiState.value.copy(
            courseCredit = value
        )
    }

    fun updateSemester(value: String) {
        _uiState.value = _uiState.value.copy(
            semester = value
        )
    }

    //    Search course
    fun searchCourse(searchText: String): MutableList<Course> {
        return courseList.filter {
            it.courseID.contains(searchText, ignoreCase = true) ||
                    it.courseName.contains(searchText, ignoreCase = true) ||
                    it.courseCredit
                        .contains(searchText, ignoreCase = true) ||
                    it.semester.contains(searchText, ignoreCase = true)
        }.toMutableList()

    }

    private fun updateAll() {
        updateID("")
        updateName("")
        updateSemester("")
        updateCredit("")
    }

    //    ADD course
    fun addCourse(context: Context) {
        val id = _uiState.value.courseID
        val name = _uiState.value.courseName
        val credit = _uiState.value.courseCredit
        val semester = _uiState.value.semester
        courseList.add(Course(id, name, credit, semester))
        updateAll()
        Toast.makeText(context, "Added course successfully", Toast.LENGTH_SHORT).show()

    }

    //    Remove course
    fun removeCourse(courseID: String, context: Context) {
        val courseToRemove = courseList.find { it.courseID == courseID }
        courseToRemove?.let {
            courseList.remove(it)
            Toast.makeText(context, "Removed course successfully", Toast.LENGTH_SHORT).show()
        }

    }

    //    Update course
    fun updateCourse(courseID: String, context: Context) {
        val courseToUpdate = courseList.find { it.courseID == courseID }
        courseToUpdate?.let {
            it.courseName = _uiState.value.courseName
            it.courseCredit = _uiState.value.courseCredit
            it.semester = _uiState.value.semester

            updateAll()
            Toast.makeText(context, "Updated course successfully", Toast.LENGTH_SHORT).show()
        }
    }


}