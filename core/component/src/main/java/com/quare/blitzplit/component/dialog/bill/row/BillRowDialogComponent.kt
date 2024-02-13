package com.quare.blitzplit.component.dialog.bill.row

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.quare.blitzplit.component.chip.bill.BillChipBackgroundColor
import com.quare.blitzplit.component.dialog.bill.model.BillColor
import com.quare.blitzplit.component.dialog.bill.row.model.BillDialogContentRowModel
import com.quare.blitzsplit.theme.BlitzSplitTheme
import com.quare.blitzsplit.theme.Red800

@Composable
fun BillRowDialogComponent(
    data: BillDialogContentRowModel,
    modifier: Modifier = Modifier,
) {
    data.run {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BilUserInfoRowComponent(
                userName = userName,
                userPicture = userPicture
            )
            BillPaymentInfoRowComponent(
                text = amount,
                textColor = amountTextColor.value,
                buttonText = buttonText,
                buttonColor = buttonTextBackGroundColor,
                buttonClick = onClickButton
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun BillRowDialogComponentPreview() {
    BlitzSplitTheme {
        BillRowDialogComponent(
            data = BillDialogContentRowModel(
                userPicture = null,
                userName = "Gabriel A.",
                amount = "R$ 15,00",
                buttonText = "Paguei",
                amountTextColor = BillColor.PAY,
                buttonTextBackGroundColor = BillChipBackgroundColor.ACTIVE,
                onClickButton = {}
            ),
        )
    }
}
