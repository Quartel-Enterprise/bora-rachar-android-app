package com.quare.blitzsplit.main.domain.model

data class MainScreenCallbacks(
    val backToLogin: () -> Unit,
    val splitBillClick: () -> Unit,
    val createGroupClick: () -> Unit
)
