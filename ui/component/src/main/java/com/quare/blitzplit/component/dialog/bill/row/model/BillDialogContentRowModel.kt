package com.quare.blitzplit.component.dialog.bill.row.model

import com.quare.blitzplit.component.chip.bill.BillChipBackgroundColor
import com.quare.blitzplit.component.dialog.bill.model.BillColor

data class BillDialogContentRowModel(
    val userPicture: String?,
    val userName: String,
    val amount: String,
    val buttonText: String,
    val amountTextColor: BillColor,
    val buttonTextBackGroundColor: BillChipBackgroundColor,
    val onClickButton: () -> Unit,
)
