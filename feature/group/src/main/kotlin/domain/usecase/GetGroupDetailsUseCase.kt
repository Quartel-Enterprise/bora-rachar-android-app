package domain.usecase

import com.quare.blitzplit.component.utils.StaticImages
import domain.model.GroupDetailsModel
import domain.model.HeaderDetailsModel
import domain.model.HeaderPriceModel
import javax.inject.Inject

class GetGroupDetailsUseCase @Inject constructor() {

    suspend operator fun invoke(): GroupDetailsModel = GroupDetailsModel(
        title = "Quartel Otaku",
        header = HeaderDetailsModel(
            photoUrl = StaticImages.DOG,
            receiveChip = HeaderPriceModel.Receive(
                value = "R$ 9.90",
                toDebit = "a 3 membros"
            ),
            payChip = HeaderPriceModel.Pay(
                value = "R$ 250",
                toDebit = "de Pierre V."
            )
        )
    )
}
