package com.quare.blitzsplit.main.domain.usecase

import com.quare.blitzplit.component.dialog.bill.model.BillColor
import com.quare.blitzplit.component.dialog.bill.model.BillDialogColouredTextModel
import com.quare.blitzsplit.main.domain.model.DebitType
import com.quare.blitzsplit.main.domain.model.DialogBillClicks
import com.quare.blitzsplit.main.domain.model.MainDialogType
import javax.inject.Inject

class GetInitialPayDialogState @Inject constructor(
    private val getBillDialogContentRowModel: GetBillDialogContentRowModel,
) {
    operator fun invoke(clicks: DialogBillClicks): MainDialogType.Bill = MainDialogType.Bill(
        title = "A pagar",
        mustShowRevertButton = true,
        items = getBillDialogContentRowModel(
            buttonText = "Paguei",
            amountTextColor = BillColor.PAY,
            onBillButtonClick = clicks.onBillButtonClick,
            debitType = DebitType.PAY
        ),
        textInfo = BillDialogColouredTextModel.Pay(
            usersAmount = 3,
            currencyText = "R$ 9,90",
            membersText = "total"
        ),
        onConfirmButtonClick = clicks.onConfirmButtonClick,
        onRevertButtonClick = clicks.onRevertButtonClick,
        onDismiss = clicks.onDismissButtonClick
    )
}
