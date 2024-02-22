package domain.model

data class HeaderDetailsModel(
    val photoUrl: String?,
    val receiveChip: HeaderPriceModel.Receive?,
    val payChip: HeaderPriceModel.Pay?,
)
