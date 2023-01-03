package com.example.uitask.screens.main

import android.Manifest
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.uitask.R
import com.example.uitask.models.MarkerModel
import com.example.uitask.models.dummyMarkerList
import com.example.uitask.screens.core.AlertDialog
import com.example.uitask.screens.core.MapMarker
import com.example.uitask.screens.core.TextButton
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.rememberCameraPositionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MainScreen() {

    val notificationPermissionState = rememberPermissionState(
        Manifest.permission.ACCESS_FINE_LOCATION
    )
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(dummyMarkerList[0].position, 17.5f)
    }
    val markerState = remember { mutableStateOf<MarkerModel?>(null) }
    val properties = remember {
        mutableStateOf(MapProperties(mapType = MapType.TERRAIN))
    }
    val context = LocalContext.current


    if (markerState.value != null) {
        AlertDialog(markerState)
    }

    if (notificationPermissionState.status.isGranted) {
        ConstraintLayout {
            val (maps, target) = createRefs()

            GoogleMap(
                modifier = Modifier
                    .fillMaxSize()
                    .constrainAs(maps) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                cameraPositionState = cameraPositionState,
                properties = properties.value
            ) {
                dummyMarkerList.forEach {
                    MapMarker(
                        context = context,
                        markerModel = it,
                        onClick = { markerModel ->
                            markerState.value = markerModel
                        }
                    )
                }
            }

            if (markerState.value == null) {
                Button(
                    onClick = { /*TODO*/ },
                    shape = CircleShape,
                    modifier = Modifier
                        .size(48.dp)
                        .constrainAs(target) {
                            end.linkTo(parent.end, 16.dp)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        },
                    colors = ButtonDefaults.textButtonColors(
                        backgroundColor = Color.White,
                        contentColor = Color.Black
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.target_icon),
                        contentDescription = "Target button icon"
                    )
                }
            }
        }
    } else {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(65.dp)
        ) {
            Image(modifier = Modifier.size(260.dp),
                painter = painterResource(id = R.drawable.my_addresses),
                contentDescription = "no addresses image"
            )
            Spacer(modifier = Modifier.size(45.dp))
            Text(text = "Add permission please", color = Color.Black)
            Spacer(modifier = Modifier.size(12.dp))
            TextButton(modifier = Modifier.width(173.dp), onClick = { notificationPermissionState.launchPermissionRequest() }, text = "Add")
        }
    }

}