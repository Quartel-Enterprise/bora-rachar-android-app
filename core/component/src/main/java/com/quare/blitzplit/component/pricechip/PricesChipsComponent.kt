package com.quare.blitzplit.component.pricechip

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quare.blitzplit.component.pricechip.model.PriceChipsModel
import com.quare.blitzplit.component.spacer.HorizontalSpacer
import com.quare.blitzplit.component.spacer.VerticalSpacer
import com.quare.blitzsplit.theme.BlitzSplitTheme
import com.quare.blitzsplit.theme.Green500
import com.quare.blitzsplit.theme.Orange500

@Composable
fun PricesChipsComponent(
    priceChipsModel: PriceChipsModel,
    modifier: Modifier = Modifier,
    clicks: PriceChipsClicks? = null,
    orientation: Orientation = Orientation.Horizontal,
) {

    val toPayComponent: @Composable () -> Unit = {
        priceChipsModel.toPay?.let {
            PriceChipComponent(
                value = it,
                color = Orange500,
                onClick = clicks?.toPay,
                orientation = orientation,
            )
            if (orientation == Orientation.Horizontal) {
                HorizontalSpacer(8.dp)
            } else {
                VerticalSpacer(4.dp)
            }
        }
    }

    val toReceiveComponent: @Composable () -> Unit = {
        priceChipsModel.toReceive?.let {
            PriceChipComponent(
                value = it,
                color = Green500,
                onClick = clicks?.toReceive,
                orientation = orientation,
            )
        }
    }

    if (orientation == Orientation.Horizontal) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            toPayComponent()
            toReceiveComponent()
        }
    } else {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {
            toPayComponent()
            toReceiveComponent()
        }
    }
}



@Composable
@Preview
fun HorizontalPricesChipsComponentPreview() {
    BlitzSplitTheme {
        PricesChipsComponent(
            priceChipsModel = PriceChipsModel(
                toPay = "R$ 19,80",
                toReceive = "R$ 250,00",
            ),
            clicks = null,
        )
    }
}

@Composable
@Preview
fun VerticalPricesChipsComponentPreview() {
    BlitzSplitTheme {
        PricesChipsComponent(
            orientation = Orientation.Vertical,
            priceChipsModel = PriceChipsModel(
                toPay = "R$ 19,80",
                toReceive = "R$ 250,00",
            ),
            clicks = null,
        )
    }
}
