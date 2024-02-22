package domain.model

sealed interface HeaderPriceModel {

    val value: String
    val toDebit: String

    data class Pay(
        override val value: String,
        override val toDebit: String,
    ) : HeaderPriceModel

    data class Receive(
        override val value: String,
        override val toDebit: String,
    ) : HeaderPriceModel
}
