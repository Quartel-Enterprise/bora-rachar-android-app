package com.quare.blitzplit.component.mainappbar.presentaiton

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quare.blitzplit.component.mainappbar.domain.MainAppBarModel
import com.quare.blitzplit.component.mainappbar.domain.PriceChipsModel
import com.quare.blitzsplit.theme.BlitzSplitTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppBar(
    data: MainAppBarModel,
    onPhotoClick: () -> Unit,
    onClickToPay: () -> Unit,
    onClickToReceive: () -> Unit,
) {
    TopAppBar(
        title = {
            PricesChipsComponent(
                priceChipsModel = data.priceChipsModel,
                onClickToPay = onClickToPay,
                onClickToReceive = onClickToReceive
            )
        },
        actions = {
            ProfilePicture(
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
        MainAppBar(
            data = MainAppBarModel(
                photoUrl = "https://avatars.githubusercontent.com/u/345075?v=4",
                priceChipsModel = PriceChipsModel(
                    toPay = "R$ 19,80",
                    toReceive = "R$ 250,00",
                ),
            ),
            onPhotoClick = {},
            onClickToPay = {},
            onClickToReceive = {}
        )
    }
}
