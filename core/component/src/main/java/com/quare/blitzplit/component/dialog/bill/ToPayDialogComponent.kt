package com.quare.blitzplit.component.dialog.bill

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.quare.blitzplit.component.chip.bill.BillChipBackgroundColor
import com.quare.blitzplit.component.dialog.bill.list.BillDialogListComponent
import com.quare.blitzplit.component.dialog.bill.model.BillColor
import com.quare.blitzplit.component.dialog.bill.model.BillDialogColouredTextModel
import com.quare.blitzplit.component.dialog.bill.row.model.BillDialogContentRowModel

@Composable
fun ToPayDialogComponent(
    onConfirmButtonClick: () -> Unit,
    onDismiss: () -> Unit,
    onRevertButtonClick: () -> Unit,
    middleContent: @Composable () -> Unit,
    isShowingRevertButton: Boolean,
    textInfo: BillDialogColouredTextModel.Pay,
) {
    BillDialog(
        title = "A Pagar",
        onConfirmButtonClick = onConfirmButtonClick,
        onDismiss = onDismiss,
        middleContent = middleContent,
        onRevertButtonClick = onRevertButtonClick,
        mustShowRevertButton = isShowingRevertButton,
        textInfo = textInfo
    )
}

@Preview
@Composable
fun ToPayDialogComponentPreview() {
    ToPayDialogComponent(
        onConfirmButtonClick = {},
        onDismiss = {},
        middleContent = {
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
        },
        onRevertButtonClick = {},
        isShowingRevertButton = true,
        textInfo = BillDialogColouredTextModel.Pay(
            currencyText = "R$ 9,90",
            usersAmount = 3,
            membersText = "grupo"
        )
    )
}
