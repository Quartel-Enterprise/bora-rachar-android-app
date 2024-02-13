package com.quare.blitzplit.component.dialog.bill.row.model

import androidx.compose.ui.graphics.Color
import com.quare.blitzplit.component.chip.bill.BillChipBackgroundColor

data class BillDialogContentRowModel(
    val userPicture: String?,
    val userName: String,
    val amount: String,
    val buttonText: String,
    val buttonTextColor: Color,
    val buttonTextBackGroundColor: BillChipBackgroundColor
)
