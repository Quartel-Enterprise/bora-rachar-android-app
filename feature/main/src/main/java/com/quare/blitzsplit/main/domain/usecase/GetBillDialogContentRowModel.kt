package com.quare.blitzsplit.main.domain.usecase

import com.quare.blitzplit.component.chip.bill.BillChipBackgroundColor
import com.quare.blitzplit.component.dialog.bill.model.BillColor
import com.quare.blitzplit.component.dialog.bill.row.model.BillDialogContentRowModel
import com.quare.blitzsplit.main.data.StaticUsersWithDebit
import com.quare.blitzsplit.main.domain.model.DebitType
import javax.inject.Inject

class GetBillDialogContentRowModel @Inject constructor() {

    operator fun invoke(
        debitType: DebitType,
        buttonText: String,
        amountTextColor: BillColor,
        onBillButtonClick: (Int) -> Unit,
    ): List<BillDialogContentRowModel> = StaticUsersWithDebit.data
        .filter { it.debitType == debitType }
        .mapIndexed { index, user ->
            BillDialogContentRowModel(
                userPicture = user.model.profilePictureUrl,
                userName = user.model.name.toString(),
                amount = user.debitAmount,
                buttonText = buttonText,
                amountTextColor = amountTextColor,
                buttonTextBackGroundColor = BillChipBackgroundColor.ACTIVE,
                onClickButton = { onBillButtonClick(index) },
            )
        }
}
