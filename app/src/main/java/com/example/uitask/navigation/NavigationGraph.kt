package com.example.uitask.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.uitask.screens.main.MainRoute
import com.example.uitask.screens.main.MainScreen
import com.example.uitask.screens.notifications.NotificationRoute
import com.example.uitask.screens.notifications.NotificationScreen
import com.example.uitask.screens.rewards.RewardsRoute
import com.example.uitask.screens.rewards.RewardsScreen
import com.example.uitask.screens.transaction.TransactionsRoute
import com.example.uitask.screens.transaction.TransactionsScreen

@Composable
fun NavigationGraph(navController: NavHostController) {

    NavHost(navController, startDestination = MainRoute.screen_route) {
        composable(MainRoute.screen_route) {
            MainScreen()
        }
        composable(TransactionsRoute.screen_route) {
            TransactionsScreen()
        }
        composable(RewardsRoute.screen_route) {
            RewardsScreen()
        }
        composable(NotificationRoute.screen_route) {
            NotificationScreen()
        }
    }
}
