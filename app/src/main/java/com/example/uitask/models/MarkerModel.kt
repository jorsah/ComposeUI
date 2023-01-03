package com.example.uitask.models

import androidx.annotation.DrawableRes
import com.example.uitask.R
import com.google.android.gms.maps.model.LatLng

data class MarkerModel(
    val position: LatLng,
    @DrawableRes val iconResourceId: Int,
    val title: String = "Armenak Armenakyan 5",
    val snippet: String = "Avinash Gupta",
    val coins: Int = 400,
    val rating: Float = 4.7f,
    val distance: Int = 3,
    val time: Int = 9,
)

val dummyMarkerList = mutableListOf(
    MarkerModel(
        position = LatLng(40.678166, -73.942980),
        title = "Gagas Arshakyan 48",
        iconResourceId = R.drawable.fox_icon
    ),
    MarkerModel(
        position = LatLng(40.678628, -73.943219),
        iconResourceId = R.drawable.tiger_icon
    ),
    MarkerModel(
        position = LatLng(40.677547, -73.941672),
        iconResourceId = R.drawable.lion_icon
    ),
    MarkerModel(
        position = LatLng(40.677812, -73.943978),
        iconResourceId = R.drawable.koala_icon
    ),
    MarkerModel(
        position = LatLng(40.680620, -73.943410),
        iconResourceId = R.drawable.car_icon
    )
)
