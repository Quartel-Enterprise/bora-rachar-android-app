package com.quare.blitzsplit.main.domain.model

data class ModalBillClicks(
    val onConfirmButtonClick: () -> Unit,
    val onRevertButtonClick: () -> Unit,
    val onDismissButtonClick: () -> Unit,
    val onBillButtonClick: (index: Int) -> Unit,
)
