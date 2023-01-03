package com.example.uitask.screens.core

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uitask.R

@Composable
fun CircleButton() {
    Button(onClick = { /*TODO*/ }, shape = CircleShape, modifier = Modifier.size(48.dp)) {
        Icon(
            painter = painterResource(id = R.drawable.target_icon),
            contentDescription = "Target button icon"
        )
    }
}