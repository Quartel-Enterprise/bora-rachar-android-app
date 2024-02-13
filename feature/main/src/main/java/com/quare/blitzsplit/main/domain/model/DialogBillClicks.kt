package com.quare.blitzsplit.main.domain.model

data class DialogBillClicks(
    val onConfirmButtonClick: () -> Unit,
    val onRevertButtonClick: () -> Unit,
    val onDismissButtonClick: () -> Unit,
    val onBillButtonClick: (index: Int) -> Unit,
)
