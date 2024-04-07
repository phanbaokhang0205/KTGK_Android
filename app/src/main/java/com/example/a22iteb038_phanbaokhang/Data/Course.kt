package com.example.a22iteb038_phanbaokhang.Data

data class Course(
    val courseID: String = "",
    var courseName: String = "",
    var courseCredit: String = "",
    var semester: String = "",
)

object ListCourse {
    val courses = listOf(
        Course("A1", "Lập trình Android","3","4"),
        Course("A2", "Lập trình hướng đối tượng","3","1"),
        Course("A3", "Lập trình Java nâng cao","3","3"),
        Course("A4", "Kiến trúc máy tính","2","3"),
        Course("A5", "Lập trình Web","3","2"),
        Course("A6", "Kỹ năng mềm IT","0","2"),
        Course("A7", "Tiếng anh chuyên ngành","3","1"),
        Course("A8", "Tiếng Anh 3","2","3"),
        Course("A9", "Cấu trúc dữ liệu và giải thuật","3","2"),
        Course("A10", "Cơ sở dữ liệu","3","1"),

    )
}