package com.example.a22IT_EB038_phan_bao_khang.UI.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.a22IT_EB038_phan_bao_khang.UI.course.AddCourseScreen
import com.example.a22IT_EB038_phan_bao_khang.UI.equation.EquationScreen
import com.example.a22IT_EB038_phan_bao_khang.UI.home.HomeScreen
import com.example.a22IT_EB038_phan_bao_khang.UI.prime.PrimeNumberScreen

enum class MyApp {
    HOME, PRIME, EQUATION, COURSE, ADD
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MyApp.HOME.name) {
        composable(route = MyApp.HOME.name) {
            HomeScreen(
                primeOnScreen = { navController.navigate(MyApp.PRIME.name) },
                equationOnScreen = { navController.navigate(MyApp.EQUATION.name) },
                courseOnScreen = { navController.navigate(MyApp.COURSE.name) })
        }
        composable(route = MyApp.PRIME.name) {
            PrimeNumberScreen(
                primeOnScreen = { navController.navigate(MyApp.PRIME.name) },
                equationOnScreen = { navController.navigate(MyApp.EQUATION.name) },
                courseOnScreen = { navController.navigate(MyApp.COURSE.name) },
                homeOnScreen = { navController.navigate(MyApp.HOME.name) }
            )
        }

        composable(route = MyApp.EQUATION.name) {
            EquationScreen(
                primeOnScreen = { navController.navigate(MyApp.PRIME.name) },
                equationOnScreen = { navController.navigate(MyApp.EQUATION.name) },
                courseOnScreen = { navController.navigate(MyApp.COURSE.name) },
                homeOnScreen = { navController.navigate(MyApp.HOME.name) }
            )
        }

        composable(route = MyApp.COURSE.name) {
            AddCourseScreen(
                primeOnScreen = { navController.navigate(MyApp.PRIME.name) },
                equationOnScreen = { navController.navigate(MyApp.EQUATION.name) },
                courseOnScreen = { navController.navigate(MyApp.COURSE.name) },
                homeOnScreen = { navController.navigate(MyApp.HOME.name) },
            )
        }

    }
}