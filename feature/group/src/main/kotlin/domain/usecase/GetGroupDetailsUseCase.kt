package domain.usecase

import com.quare.blitzplit.component.chip.price.PriceChipsClicks
import com.quare.blitzplit.component.utils.StaticImages
import domain.model.GroupDetailsModel
import domain.model.HeaderDetailsModel
import domain.model.HeaderPriceModel
import javax.inject.Inject

class GetGroupDetailsUseCase @Inject constructor() {

    suspend operator fun invoke(
        clicks: PriceChipsClicks,
    ): GroupDetailsModel = GroupDetailsModel(
        title = "Quartel Otaku",
        header = HeaderDetailsModel(
            photoUrl = StaticImages.DOG,
            payChip = HeaderPriceModel.Pay(
                text = "Pagar R$ 9.90 a 3 membros",
                onClick = clicks.toPay
            ),
            receiveChip = HeaderPriceModel.Receive(
                text = "Receber R$ 250 de Pierre V.",
                onClick = clicks.toReceive
            )
        )
    )
}
