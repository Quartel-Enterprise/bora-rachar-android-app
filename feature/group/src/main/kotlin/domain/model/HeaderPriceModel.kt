package domain.model

sealed interface HeaderPriceModel {

    val text: String
    val onClick: () -> Unit

    data class Pay(
        override val text: String,
        override val onClick: () -> Unit,
    ) : HeaderPriceModel

    data class Receive(
        override val text: String,
        override val onClick: () -> Unit,
    ) : HeaderPriceModel
}
