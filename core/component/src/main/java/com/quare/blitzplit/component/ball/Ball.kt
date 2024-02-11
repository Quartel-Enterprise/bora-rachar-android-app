package com.quare.blitzplit.component.ball

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quare.blitzplit.component.ball.model.BallModel

@Composable
fun BallComponent(
    ballModel: BallModel,
    size: Dp,
    text: String,
    textColor: Color,
    modifier: Modifier = Modifier,
    textSize: TextUnit = 14.sp,
) {
    Surface(
        modifier = modifier
            .size(size),
        shape = CircleShape,
        color = ballModel.color
    ) {
        Box(
            modifier = if (ballModel is BallModel.WithBorder) {
                Modifier.border(
                    width = 1.dp,
                    color = ballModel.borderColor,
                    shape = CircleShape
                )
            } else {
                Modifier
            }.fillMaxSize()
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = text,
                style = TextStyle(
                    color = textColor,
                    fontSize = textSize
                )
            )
        }
    }
}
