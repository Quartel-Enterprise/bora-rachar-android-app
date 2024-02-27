package com.quare.blitzplit.component.dialog.bill.row

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quare.blitzplit.component.chip.bill.BillChipBackgroundColor
import com.quare.blitzplit.component.chip.bill.BillChipComponent
import com.quare.blitzplit.component.spacer.HorizontalSpacer
import com.quare.blitzsplit.theme.BlitzSplitTheme
import com.quare.blitzsplit.theme.Red800

@Composable
fun BillPaymentInfoRowComponent(
    text: String,
    textColor: Color,
    buttonText: String,
    buttonColor: BillChipBackgroundColor,
    modifier: Modifier = Modifier,
    buttonClick: () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = textColor,
                fontSize = 11.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp,
                textAlign = TextAlign.Right
            )
        )
        HorizontalSpacer(10.dp)
        BillChipComponent(
            color = buttonColor,
            buttonText = buttonText,
            onClick = buttonClick
        )
    }
}

@Composable
@Preview(showBackground = true)
fun BillPaymentInfoRowComponentPreview() {
    BlitzSplitTheme {
        BillPaymentInfoRowComponent(
            text = "R$ 15,00",
            textColor = Red800,
            buttonText = "Paguei",
            buttonColor = BillChipBackgroundColor.ACTIVE,
            buttonClick = {}
        )
    }
}
