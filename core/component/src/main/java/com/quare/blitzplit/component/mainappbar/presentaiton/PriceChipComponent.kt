package com.quare.blitzplit.component.mainappbar.presentaiton

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quare.blitzsplit.theme.BlitzSplitTheme
import com.quare.blitzsplit.theme.Orange500

@Composable
fun PriceChipComponent(
    value: String,
    color: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(50.dp))
            .background(color = color)
            .clickable(onClick = onClick)
            .padding(
                horizontal = 8.dp,
                vertical = 4.dp
            )
    ) {
        Text(
            fontSize = 14.sp,
            text = value,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
@Preview
fun PriceChipComponentPreview() {
    BlitzSplitTheme {
        PriceChipComponent(
            value = "R$ 19.80",
            color = Orange500,
            onClick = {}
        )
    }
}
