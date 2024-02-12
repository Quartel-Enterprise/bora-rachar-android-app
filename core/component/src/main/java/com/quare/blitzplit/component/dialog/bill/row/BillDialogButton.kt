package com.quare.blitzplit.component.dialog.bill.row

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quare.blitzplit.component.dialog.bill.row.model.BillButtonBackgroundColor
import com.quare.blitzsplit.theme.BlitzSplitTheme

@Composable
fun BillDialogButton(
    color: BillButtonBackgroundColor,
    buttonText: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = color.value
        ),
        contentPadding = PaddingValues(
            horizontal = 0.dp,
            vertical = 0.dp
        )
    ) {
        Text(
            text = buttonText,
            style = TextStyle(
                color = Color.White,
                lineHeight = 20.sp,
                fontSize = 12.sp,
                letterSpacing = 0.1.sp,
                fontWeight = FontWeight.W500
            ),
        )
    }
}

@Composable
@Preview
fun BillDialogButtonPayPreview() {
    BlitzSplitTheme {
        BillDialogButton(
            color = BillButtonBackgroundColor.ACTIVE,
            buttonText = "Paguei",
            onClick = {}
        )
    }
}
