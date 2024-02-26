package com.quare.blitzsplit.main.domain.usecase

import com.quare.blitzplit.component.dialog.bill.model.BillColor
import com.quare.blitzplit.component.dialog.bill.model.BillDialogColouredTextModel
import com.quare.blitzsplit.main.domain.model.DebitType
import com.quare.blitzsplit.main.domain.model.ModalBillClicks
import com.quare.blitzsplit.main.domain.model.MainModalType
import com.quare.blitzsplit.utils.CurrencyFormatter
import javax.inject.Inject

class GetInitialPayModalStateUseCase @Inject constructor(
    private val getBillDialogContentRowModel: GetBillDialogContentRowModel,
    private val currencyFormatter: CurrencyFormatter
) {
    operator fun invoke(clicks: ModalBillClicks): MainModalType.Bill = MainModalType.Bill(
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
            currencyText = currencyFormatter.format(9.90),
            membersText = "total"
        ),
        onConfirmButtonClick = clicks.onConfirmButtonClick,
        onRevertButtonClick = clicks.onRevertButtonClick,
        onDismiss = clicks.onDismissButtonClick
    )
}
