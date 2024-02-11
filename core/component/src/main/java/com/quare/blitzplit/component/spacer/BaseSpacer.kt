package com.quare.blitzplit.component.spacer

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun BaseSpacer(orientation: Orientation, size: Dp) {
   val modifier = when (orientation) {
        Orientation.Vertical -> Modifier.height(size)
        Orientation.Horizontal -> Modifier.width(size)
    }
    Spacer(modifier = modifier)
}
