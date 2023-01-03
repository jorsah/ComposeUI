package com.example.uitask.screens.core

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uitask.R

@Composable
fun TopAppBar() {
    TopAppBar(
        backgroundColor = Color.White,
        elevation = 50.dp,
        title = {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 48.dp),
                text = "My addresses",
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 17.sp
            )
        },
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.menu_icon),
                contentDescription = "Top app bar icon",
                tint = Color.Black
            )
        })
}
