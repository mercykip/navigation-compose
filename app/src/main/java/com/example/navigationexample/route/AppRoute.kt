package com.example.navigationexample.route

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.example.navigationexample.R
import com.example.navigationexample.presentation.screen.ScreenOne
import com.example.navigationexample.presentation.screen.ScreenThreeArg
import com.example.navigationexample.presentation.screen.ScreenTwo
import com.example.navigationexample.presentation.screen.ScreenDeepLink


sealed class Screen(val route: String) {
    object ScreenOne : Screen("screen_one")
    object ScreenTwo : Screen("screen_two")
    object ScreenDeepLink : Screen("screen_deep_link")
    object ScreenThreeArg : Screen("screen_three_arg")
}

@Composable
fun AppRoute(navController: NavHostController) {
    val uri = "https://stackoverflow.com"



    NavHost(navController = navController, startDestination = Screen.ScreenOne.route) {
        composable(Screen.ScreenOne.route) { ScreenOne(navController) }
        composable(Screen.ScreenTwo.route) { ScreenTwo(navController) }
        composable(
            "${Screen.ScreenThreeArg.route}/{userId}",
            arguments = listOf(navArgument("userId") { type = NavType.StringType })
        ) { backStackEntry ->
            ScreenThreeArg(navController, backStackEntry.arguments?.getString("userId"))
        }
        composable(
            "${Screen.ScreenDeepLink.route}?id={id}",
            deepLinks = listOf(navDeepLink { uriPattern = "$uri/{id}" })
        ) { backStackEntry ->
            ScreenDeepLink(navController, backStackEntry.arguments?.getString("id"))
        }
    }
}
