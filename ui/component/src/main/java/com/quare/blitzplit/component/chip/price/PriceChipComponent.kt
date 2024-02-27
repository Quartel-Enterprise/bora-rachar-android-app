package com.quare.blitzplit.component.chip.price

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quare.blitzplit.component.chip.ChipComponent
import com.quare.blitzsplit.theme.BlitzSplitTheme
import com.quare.blitzsplit.theme.Orange500

@Composable
fun PriceChipComponent(
    value: String,
    color: Color,
    modifier: Modifier = Modifier,
    orientation: Orientation = Orientation.Vertical,
    onClick: (() -> Unit)?,
) {
    ChipComponent(
        modifier = modifier,
        value = value,
        color = color,
        paddingValues = PaddingValues(
            vertical = getVerticalPadding(orientation),
            horizontal = 7.5.dp
        ),
        fontSize = 14.sp,
        onClick = onClick
    )
}

@Composable
private fun getVerticalPadding(orientation: Orientation): Dp =
    if (orientation == Orientation.Horizontal) 3.dp else 1.dp

@Composable
@Preview
fun VerticalPriceChipComponentPreview() {
    BlitzSplitTheme {
        PriceChipComponent(
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
        PriceChipComponent(
            value = "R$ 19,80",
            color = Orange500,
            onClick = {},
            orientation = Orientation.Horizontal
        )
    }
}
