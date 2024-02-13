package com.quare.blitzplit.component.dialog.bill.model

sealed class BillDialogColouredTextModel(
    val connectorText: String,
    val infoText: String,
    val color: BillColor,
) {

    abstract val usersAmount: Int
    abstract val  currencyText: String
    abstract val membersText: String

    data class Pay(
        override val usersAmount: Int,
        override val currencyText: String,
        override val membersText: String
    ): BillDialogColouredTextModel(
        infoText = "a pagar",
        connectorText = "para",
        color = BillColor.PAY
    )

    data class Receive(
        override val usersAmount: Int,
        override val currencyText: String,
        override val membersText: String
    ): BillDialogColouredTextModel(
        infoText = "a receber",
        connectorText = "de",
        color = BillColor.RECEIVE
    )
}
