package com.quare.blitzsplit.main.domain.usecase

import com.quare.blitzplit.component.dialog.bill.model.BillColor
import com.quare.blitzplit.component.dialog.bill.model.BillDialogColouredTextModel
import com.quare.blitzsplit.main.domain.model.DebitType
import com.quare.blitzsplit.main.domain.model.ModalBillClicks
import com.quare.blitzsplit.main.domain.model.MainModalType
import javax.inject.Inject

class GetInitialReceiveModalStateUseCase @Inject constructor(
    private val getBillDialogContentRowModel: GetBillDialogContentRowModel,
) {

    operator fun invoke(clicks: ModalBillClicks): MainModalType.Bill = MainModalType.Bill(
        title = "A receber",
        mustShowRevertButton = true,
        items = getBillDialogContentRowModel(
            buttonText = "Recebi",
            amountTextColor = BillColor.RECEIVE,
            onBillButtonClick = clicks.onBillButtonClick,
            debitType = DebitType.RECEIVE
        ),
        textInfo = BillDialogColouredTextModel.Receive(
            usersAmount = 3,
            currencyText = "R$ 250,00",
            membersText = "total"
        ),
        onConfirmButtonClick = clicks.onConfirmButtonClick,
        onRevertButtonClick = clicks.onRevertButtonClick,
        onDismiss = clicks.onDismissButtonClick
    )
}
