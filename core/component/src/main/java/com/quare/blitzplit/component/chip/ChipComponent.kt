package com.quare.blitzplit.component.chip

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quare.blitzplit.component.utils.onNullableClick

@Composable
fun ChipComponent(
    value: String,
    color: Color,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 14.sp,
    onClick: (() -> Unit)? = null,
) {
    Box(
        modifier = modifier
            .base(color = color)
            .onNullableClick(onClick = onClick)
            .padding(paddingValues)
    ) {
        Text(
            fontSize = fontSize,
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
