package com.quare.blitzsplit.main.domain.model

import com.quare.blitzplit.component.dialog.bill.model.BillDialogColouredTextModel
import com.quare.blitzplit.component.dialog.bill.row.model.BillDialogContentRowModel

sealed interface MainDialogType {

    val onDismiss: () -> Unit

    data class Logout(
        val onLogout: () -> Unit,
        override val onDismiss: () -> Unit,
    ) : MainDialogType

    data class Bill(
        val title: String,
        val mustShowRevertButton: Boolean,
        val items: List<BillDialogContentRowModel>,
        val textInfo: BillDialogColouredTextModel,
        val onConfirmButtonClick: () -> Unit,
        val onRevertButtonClick: () -> Unit,
        override val onDismiss: () -> Unit,
    ) : MainDialogType
}
