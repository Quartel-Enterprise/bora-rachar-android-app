package com.quare.blitzsplit.groups.presentation.components.group

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quare.blitzplit.component.ball.BallComponent
import com.quare.blitzplit.component.ball.model.BallModel
import com.quare.blitzsplit.theme.BlitzSplitTheme
import com.quare.blitzsplit.theme.Orange500

@Composable
fun UserDebitsAmountComponent(
    amount: Int,
    modifier: Modifier = Modifier,
) {
    BallComponent(
        modifier = modifier,
        ballModel = BallModel.Filled(Orange500),
        size = 19.dp,
        text = amount.toString(),
        textColor = Color.White,
    )
}

@Composable
@Preview
fun UserDebitsAmountComponentPreview() {
    BlitzSplitTheme {
        UserDebitsAmountComponent(
            amount = 3
        )
    }
}
