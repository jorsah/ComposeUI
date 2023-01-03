package com.example.uitask.screens.core

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.uitask.ui.theme.Orange

@Composable
fun TextWithIcon(
    modifier: Modifier = Modifier,
    painter: Painter,
    text: String,
    fontSize: TextUnit,
    tint: Color = Orange,
    fontWeight: FontWeight? = null
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painter,
            contentDescription = "ratings icon",
            tint = tint
        )
        Spacer(modifier = Modifier.size(12.dp))
        Text(
            text = text,
            fontSize = fontSize,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontWeight = fontWeight
        )
    }
}