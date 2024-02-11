package com.quare.blitzplit.component.ball.model

import androidx.compose.ui.graphics.Color

sealed class BallModel(val color: Color ) {
    class Filled(color: Color) : BallModel(color)
    data class WithBorder(val borderColor: Color) : BallModel(Color.Transparent)
}
