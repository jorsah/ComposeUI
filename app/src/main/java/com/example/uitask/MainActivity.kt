package com.example.uitask

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.example.uitask.navigation.NavigationGraph
import com.example.uitask.screens.core.BottomNavigation
import com.example.uitask.screens.core.FloatingActionButton
import com.example.uitask.screens.core.TopAppBar
import com.example.uitask.ui.theme.UITaskTheme

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UITaskTheme {
                val navController = rememberNavController()
                Scaffold(
                    topBar = {
                        TopAppBar()
                    },
                    floatingActionButton = {
                        FloatingActionButton(onClick = { /*TODO*/ })
                    },
                    bottomBar = { BottomNavigation(navController = navController) }
                ) {
                    NavigationGraph(navController = navController)
                }
            }
        }
        hideSystemUI()
    }

    private fun hideSystemUI() {
        actionBar?.hide()
        WindowCompat.setDecorFitsSystemWindows(window, false)

        window.insetsController?.apply {
            hide(WindowInsets.Type.statusBars())
            systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }
}
