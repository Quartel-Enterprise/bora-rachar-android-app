package com.quare.blitzplit.component.chip

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quare.blitzplit.component.utils.onNullableClick
import com.quare.blitzsplit.theme.BlitzSplitTheme
import com.quare.blitzsplit.theme.Orange500

@Composable
fun ChipComponent(
    value: String,
    color: Color,
    modifier: Modifier = Modifier,
    orientation: Orientation = Orientation.Vertical,
    onClick: (() -> Unit)? = null,
) {
    val verticalPadding = getVerticalPadding(orientation)
    Box(
        modifier = modifier
            .base(color = color)
            .onNullableClick(onClick = onClick)
            .padding(
                horizontal = 7.5.dp,
                vertical = verticalPadding
            )
    ) {
        Text(
            fontSize = 14.sp,
            text = value,
            color = Color.White,
            lineHeight = 20.sp,
            letterSpacing = 0.1.sp,
            fontWeight = FontWeight.W500
        )
    }
}

private fun Modifier.base(color: Color): Modifier = this
    .clip(shape = RoundedCornerShape(50.dp))
    .background(color = color)

@Composable
private fun getVerticalPadding(orientation: Orientation): Dp =
    if (orientation == Orientation.Horizontal) 3.dp else 1.dp

@Composable
@Preview
fun VerticalPriceChipComponentPreview() {
    BlitzSplitTheme {
        ChipComponent(
            value = "R$ 19,80",
            color = Orange500,
            onClick = {},
            orientation = Orientation.Vertical
        )
    }
}

@Composable
@Preview
fun HorizontalPriceChipComponentPreview() {
    BlitzSplitTheme {
        ChipComponent(
            value = "R$ 19,80",
            color = Orange500,
            onClick = {},
            orientation = Orientation.Horizontal
        )
    }
}
