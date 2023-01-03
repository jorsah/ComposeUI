package com.example.uitask.screens.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.uitask.R
import com.example.uitask.screens.main.MainRoute
import com.example.uitask.screens.notifications.NotificationRoute
import com.example.uitask.screens.rewards.RewardsRoute
import com.example.uitask.screens.transaction.TransactionsRoute
import com.example.uitask.ui.theme.Gray
import com.example.uitask.ui.theme.Orange

@Composable
fun BottomNavigation(navController: NavController) {
    val inputValue = remember { mutableStateOf(TextFieldValue()) }

    val items = listOf(
        MainRoute,
        TransactionsRoute,
        RewardsRoute,
        NotificationRoute
    )

    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(12.dp))
            .background(Color.White)
    ) {
        Row(modifier = Modifier.padding(all = 16.dp)) {
            TextField(
                value = inputValue.value,
                onValueChange = {
                    inputValue.value = it
                },
                singleLine = true,
                leadingIcon = {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.search_icon),
                        contentDescription = "Search Icon"
                    )
                },
                placeholder = {
                    Text(text = "Search")
                },
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Orange,
                    leadingIconColor = Color.Black,
                    focusedIndicatorColor = Orange,
                    placeholderColor = Gray,
                    textColor = Color.Black
                )
            )

            TextButton(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .clip(shape = RoundedCornerShape(12.dp))
                    .size(width = 75.dp, height = 48.dp),
                onClick = { /*TODO*/ },
                text = "Find"
            )
        }
        BottomNavigation(backgroundColor = Color.White) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            items.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = item.title
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            fontSize = 9.sp
                        )
                    },
                    selectedContentColor = Orange,
                    unselectedContentColor = Gray,
                    alwaysShowLabel = true,
                    selected = currentRoute == item.screen_route,
                    onClick = {
                        navController.navigate(item.screen_route) {

                            navController.graph.startDestinationRoute?.let { screen_route ->
                                popUpTo(screen_route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}
