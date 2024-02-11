package com.quare.blitzsplit.groups.presentation.components.group

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quare.blitzplit.component.pricechip.model.PriceChipsModel
import com.quare.blitzplit.component.pricechip.PricesChipsComponent
import com.quare.blitzplit.component.spacer.VerticalSpacer
import com.quare.blitzsplit.groups.domain.model.MoreParticipantsModel
import com.quare.blitzsplit.theme.BlitzSplitTheme

@Composable
internal fun RowGroupInfo(
    name: String,
    profilePictures: List<String?>,
    moreParticipants: MoreParticipantsModel,
    priceChipsModel: PriceChipsModel,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = name,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.15.sp
            )
            VerticalSpacer(4.dp)
            GroupUsersPicturesComponent(
                profilePictures = profilePictures,
                moreParticipants = moreParticipants
            )
        }
        PricesChipsComponent(
            priceChipsModel = priceChipsModel,
            orientation = Orientation.Vertical
        )
    }
}

@Composable
@Preview(showBackground = true)
fun RowGroupInfoPreview() {
    BlitzSplitTheme {
        RowGroupInfo(
            name = "Name",
            profilePictures = listOf(
                null,
                null,
                null
            ),
            moreParticipants = MoreParticipantsModel(
                shouldShow = true,
                amount = 3
            ),
            priceChipsModel = PriceChipsModel(
                toPay = "R$ 9,90",
                toReceive = "R$ 250,00",
            )
        )
    }
}
