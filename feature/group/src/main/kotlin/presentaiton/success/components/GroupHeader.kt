package presentaiton.success.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quare.blitzplit.component.spacer.HorizontalSpacer
import com.quare.blitzplit.component.utils.StaticImages
import com.quare.blitzsplit.theme.BlitzSplitTheme
import domain.model.HeaderDetailsModel
import domain.model.HeaderPriceModel

@Composable
fun GroupHeader(
    headerDetails: HeaderDetailsModel,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        GroupImage(url = headerDetails.photoUrl)
        HorizontalSpacer(12.dp)
        GroupsHeaderPricesChipComponent(
            modifier = Modifier.fillMaxHeight(),
            receiveChip = headerDetails.receiveChip,
            payChip = headerDetails.payChip
        )
    }
}

@Composable
@Preview(showBackground = true)
fun GroupHeaderPreview() {
    BlitzSplitTheme {
        GroupHeader(
            headerDetails = HeaderDetailsModel(
                photoUrl = StaticImages.DOG,
                receiveChip = HeaderPriceModel.Receive(
                    text = "Receber R$ 250 de Pierre V.",
                    onClick = {}
                ),
                payChip = HeaderPriceModel.Pay(
                    text = "Pagar R$ 9.90 a 3 membros",
                    onClick = {}
                )
            )
        )
    }
}
