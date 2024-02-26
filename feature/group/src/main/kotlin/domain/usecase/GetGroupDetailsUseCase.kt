package domain.usecase

import com.quare.blitzplit.component.chip.price.PriceChipsClicks
import com.quare.blitzplit.component.utils.StaticImages
import com.quare.blitzsplit.utils.CurrencyFormatter
import domain.model.GroupDetailsModel
import domain.model.HeaderDetailsModel
import domain.model.HeaderPriceModel
import javax.inject.Inject

class GetGroupDetailsUseCase @Inject constructor(
    private val currencyFormatter: CurrencyFormatter
) {

    suspend operator fun invoke(
        clicks: PriceChipsClicks,
    ): GroupDetailsModel = GroupDetailsModel(
        title = "Quartel Otaku",
        header = HeaderDetailsModel(
            photoUrl = StaticImages.DOG,
            payChip = HeaderPriceModel.Pay(
                text = "Pagar ${currencyFormatter.format(9.9)} a 3 membros",
                onClick = clicks.toPay
            ),
            receiveChip = HeaderPriceModel.Receive(
                text = "Receber ${currencyFormatter.format(250)} de Pierre V.",
                onClick = clicks.toReceive
            )
        )
    )
}
