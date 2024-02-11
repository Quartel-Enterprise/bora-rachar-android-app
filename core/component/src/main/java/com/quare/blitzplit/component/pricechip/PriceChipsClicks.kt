package com.quare.blitzplit.component.pricechip

data class PriceChipsClicks(
    val toPay: () -> Unit,
    val toReceive: () -> Unit,
)
