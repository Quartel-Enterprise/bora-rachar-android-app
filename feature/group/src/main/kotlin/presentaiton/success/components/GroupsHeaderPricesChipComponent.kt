package presentaiton.success.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.quare.blitzsplit.theme.BlitzSplitTheme
import com.quare.blitzsplit.theme.Green500
import com.quare.blitzsplit.theme.Orange500
import domain.model.HeaderPriceModel

@Composable
fun GroupsHeaderPricesChipComponent(
    receiveChip: HeaderPriceModel.Receive?,
    payChip: HeaderPriceModel.Pay?,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        val buttonModifier = Modifier.fillMaxWidth()
        payChip?.let {
            GroupHeaderPriceButton(
                modifier = buttonModifier,
                text = it.text,
                onClick = it.onClick,
                color = Orange500
            )
        }
        receiveChip?.let {
            GroupHeaderPriceButton(
                modifier = buttonModifier,
                text = it.text,
                onClick = it.onClick,
                color = Green500
            )
        }
    }
}

@Composable
@Preview
fun GroupsHeaderPricesChipComponentPreview() {
    BlitzSplitTheme {
        GroupsHeaderPricesChipComponent(
            receiveChip = HeaderPriceModel.Receive(
                text = "Receber R$ 250",
                onClick = {}
            ),
            payChip = HeaderPriceModel.Pay(
                text = "Pagar R$ 9.90 a 3 membros",
                onClick = {}
            )
        )
    }
}
