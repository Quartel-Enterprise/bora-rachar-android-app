package com.quare.blitzplit.component.mainappbar.presentaiton

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quare.blitzplit.component.mainappbar.domain.PriceChipsModel
import com.quare.blitzplit.component.spacer.HorizontalSpacer
import com.quare.blitzsplit.theme.Green500
import com.quare.blitzsplit.theme.Orange500

@Composable
fun PricesChipsComponent(
    priceChipsModel: PriceChipsModel,
    onClickToPay: () -> Unit,
    onClickToReceive: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier) {
        priceChipsModel.toPay?.let {
            PriceChipComponent(
                value = it,
                color = Orange500,
                onClick = onClickToPay
            )
            HorizontalSpacer(8.dp)
        }
        priceChipsModel.toReceive?.let {
            PriceChipComponent(
                value = it,
                color = Green500,
                onClick = onClickToReceive
            )
        }
    }
}

@Composable
@Preview
fun PricesChipsComponentPreview() {
    PricesChipsComponent(
        priceChipsModel = PriceChipsModel(
            toPay = "R$ 19,80",
            toReceive = "R$ 250,00",
        ),
        onClickToPay = {},
        onClickToReceive = {}
    )
}
