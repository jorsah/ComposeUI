package com.example.uitask.screens.core

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.uitask.ui.theme.Orange

@Composable
fun TextButton(modifier: Modifier, onClick: () -> Unit, text: String) {
    Button(
        modifier = modifier.height(48.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.textButtonColors(backgroundColor = Orange),
        onClick = onClick
    ) {
        Text(text, color = Color.White)
    }
}
