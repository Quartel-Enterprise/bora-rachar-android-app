package com.quare.blitzplit.component.chip.price

data class PriceChipsClicks(
    val toPay: () -> Unit,
    val toReceive: () -> Unit,
)
