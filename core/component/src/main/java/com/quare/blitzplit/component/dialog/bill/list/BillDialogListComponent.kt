package com.quare.blitzplit.component.dialog.bill.list

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quare.blitzplit.component.chip.bill.BillChipBackgroundColor
import com.quare.blitzplit.component.dialog.bill.model.BillColor
import com.quare.blitzplit.component.dialog.bill.row.BillRowDialogComponent
import com.quare.blitzplit.component.dialog.bill.row.model.BillDialogContentRowModel
import com.quare.blitzplit.component.spacer.VerticalSpacer
import com.quare.blitzsplit.theme.BlitzSplitTheme
import com.quare.blitzsplit.utils.isLastIndex

@Composable
fun BillDialogListComponent(
    data: List<BillDialogContentRowModel>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier) {
        data.forEachIndexed { index, billDialogContentRowModel ->
            item {
                BillRowDialogComponent(
                    data = billDialogContentRowModel,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            if (!data.isLastIndex(index)) {
                item {
                    VerticalSpacer(8.dp)
                    HorizontalDivider()
                    VerticalSpacer(8.dp)
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun BillDialogListComponentPreview() {
    BlitzSplitTheme {
        BillDialogListComponent(
            data = listOf(
                BillDialogContentRowModel(
                    userPicture = null,
                    userName = "Gabriel A.",
                    amount = "R$ 15,00",
                    buttonText = "Paguei",
                    amountTextColor = BillColor.PAY,
                    buttonTextBackGroundColor = BillChipBackgroundColor.ACTIVE,
                    onClickButton = {}
                ),
                BillDialogContentRowModel(
                    userPicture = null,
                    userName = "Thiago D.",
                    amount = "R$ 1,30",
                    buttonText = "Paguei",
                    amountTextColor = BillColor.PAY,
                    buttonTextBackGroundColor = BillChipBackgroundColor.ACTIVE,
                    onClickButton = {}
                ),
                BillDialogContentRowModel(
                    userPicture = null,
                    userName = "Fabrício\nK.",
                    amount = "R$ 249,99",
                    buttonText = "Paguei",
                    amountTextColor = BillColor.PAY,
                    buttonTextBackGroundColor = BillChipBackgroundColor.ACTIVE,
                    onClickButton = {}
                )
            )
        )
    }
}
