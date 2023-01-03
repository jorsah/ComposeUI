package com.example.uitask.screens.core

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.uitask.ui.theme.Orange

@Composable
fun FloatingActionButton(
    onClick: () -> Unit,
) {
    FloatingActionButton(onClick = { onClick() }, backgroundColor = Color.White) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add", tint = Orange)
    }
}