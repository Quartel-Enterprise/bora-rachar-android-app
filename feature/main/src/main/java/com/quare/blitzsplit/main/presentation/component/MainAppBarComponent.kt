package com.quare.blitzsplit.main.presentation.component

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quare.blitzplit.component.chip.price.model.PriceChipsModel
import com.quare.blitzplit.component.picture.profile.UserProfilePicture
import com.quare.blitzplit.component.chip.price.PriceChipsClicks
import com.quare.blitzplit.component.chip.price.PricesChipsComponent
import com.quare.blitzsplit.main.domain.model.MainAppBarModel
import com.quare.blitzsplit.theme.BlitzSplitTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppBarComponent(
    data: MainAppBarModel,
    onPhotoClick: () -> Unit,
    priceChipsClicks: PriceChipsClicks,
) {
    TopAppBar(
        title = {
            data.priceChipsModel?.let {
                PricesChipsComponent(
                    priceChipsModel = it,
                    clicks = priceChipsClicks,
                    orientation = Orientation.Horizontal
                )
            }
        },
        actions = {
            UserProfilePicture(
                size = 30.dp,
                modifier = Modifier.padding(end = 16.dp),
                photoUrl = data.photoUrl,
                onPhotoClick = onPhotoClick
            )
        }
    )
}

@Composable
@Preview
fun MainAppBarPreview() {
    BlitzSplitTheme {
        MainAppBarComponent(
            data = MainAppBarModel(
                photoUrl = "https://avatars.githubusercontent.com/u/345075?v=4",
                priceChipsModel = PriceChipsModel(
                    toPay = "R$ 19,80",
                    toReceive = "R$ 250,00",
                ),
            ),
            onPhotoClick = {},
            priceChipsClicks = PriceChipsClicks(
                toPay = {},
                toReceive = {},
            )
        )
    }
}
