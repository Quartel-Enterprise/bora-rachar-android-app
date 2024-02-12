package com.quare.blitzsplit.groups.presentation.components.group

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.quare.blitzplit.component.chip.price.model.PriceChipsModel
import com.quare.blitzsplit.groups.data.StaticImages
import com.quare.blitzsplit.groups.domain.model.GroupsScreenItem
import com.quare.blitzsplit.groups.domain.model.MoreParticipantsModel
import com.quare.blitzsplit.groups.domain.model.UserDebitsModel
import com.quare.blitzsplit.theme.BlitzSplitTheme
import com.quare.blitzsplit.theme.Blue200

@Composable
fun GroupItemComponent(
    onClick: () -> Unit,
    data: GroupsScreenItem.GroupItem,
    modifier: Modifier = Modifier,
    height: Dp = 80.dp,
) {
    data.run {
        Box(
            modifier = modifier
                .clip(shape = RoundedCornerShape(12.dp))
                .background(Blue200)
                .fillMaxWidth()
                .height(height)
                .clickable(onClick = onClick),
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                GroupImageWithDebitsComponent(
                    imageSize = height,
                    name = name,
                    imageUrl = imageUrl,
                    userDebits = userDebits
                )
                RowGroupInfo(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    name = name,
                    profilePictures = profilePictures,
                    moreParticipants = moreParticipants,
                    chipsComponent = {
                        GroupChipsComponent(data)
                    }
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun GroupItemComponentPreview() {
    BlitzSplitTheme {
        GroupItemComponent(
            data = GroupsScreenItem.GroupItem.WithDebits(
                name = "Quartel Otaku",
                imageUrl = StaticImages.DOG,
                profilePictures = listOf(
                    StaticImages.ARRIGHI,
                    StaticImages.THIAGO,
                    StaticImages.FABIRCIO,
                    StaticImages.PIERRE
                ),
                id = "1",
                priceChipsModel = PriceChipsModel(
                    toPay = "R$ 9,90",
                    toReceive = "R$ 250,00"
                ),
                moreParticipants = MoreParticipantsModel(
                    amount = 3,
                    shouldShow = true,
                ),
                userDebits = UserDebitsModel(
                    amount = 3,
                    shouldShow = true,
                )
            ),
            onClick = {}
        )
    }
}
