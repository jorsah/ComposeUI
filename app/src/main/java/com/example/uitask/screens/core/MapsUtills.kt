package com.example.uitask.screens.core

import android.content.Context
import android.graphics.Bitmap
import androidx.compose.runtime.Composable
import androidx.core.content.ContextCompat
import com.example.uitask.models.MarkerModel
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState

@Composable
fun MapMarker(
    context: Context,
    markerModel: MarkerModel,
    onClick: (MarkerModel) -> Unit = { }
) {
    val icon = bitmapDescriptor(
        context, markerModel.iconResourceId
    )
    Marker(
        state = MarkerState(position = markerModel.position),
        title = markerModel.title,
        snippet = markerModel.snippet,
        icon = icon,
        onClick = {
            onClick(markerModel)
            true
        }
    )
}

fun bitmapDescriptor(
    context: Context,
    vectorResId: Int
): BitmapDescriptor? {

    val drawable = ContextCompat.getDrawable(context, vectorResId) ?: return null
    drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
    val bm = Bitmap.createBitmap(
        drawable.intrinsicWidth,
        drawable.intrinsicHeight,
        Bitmap.Config.ARGB_8888
    )

    val canvas = android.graphics.Canvas(bm)
    drawable.draw(canvas)
    return BitmapDescriptorFactory.fromBitmap(bm)
}
