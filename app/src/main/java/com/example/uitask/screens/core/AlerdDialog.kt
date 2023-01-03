package com.example.uitask.screens.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.uitask.R
import com.example.uitask.models.MarkerModel
import com.example.uitask.ui.theme.Gray
import com.example.uitask.ui.theme.Orange

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AlertDialog(markerModel: MutableState<MarkerModel?>) {

    val model: MarkerModel = markerModel.value!!
    Dialog(
        onDismissRequest = { markerModel.value = null },
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Card(
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .padding(8.dp),
            elevation = 8.dp
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(14.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "${markerModel.value?.coins} Coins",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Orange,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.size(24.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = model.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = model.snippet,
                        fontSize = 17.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                    Divider(
                        color = Gray,
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .height(12.dp)
                            .width(1.dp)
                    )
                    TextWithIcon(
                        painter = painterResource(id = R.drawable.star_icon),
                        text = model.rating.toString(),
                        fontSize = 17.sp,
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    TextWithIcon(
                        painter = painterResource(id = R.drawable.distance_icon),
                        text = "${model.distance} mi",
                        fontSize = 17.sp,
                        tint = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.size(18.dp))
                    TextWithIcon(
                        painter = painterResource(id = R.drawable.time_icon),
                        text = "${model.time} m",
                        fontSize = 17.sp,
                        tint = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.size(12.dp))
                TextButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        markerModel.value = null
                    },
                    text = "Book Spot"
                )
            }
        }
    }
}
