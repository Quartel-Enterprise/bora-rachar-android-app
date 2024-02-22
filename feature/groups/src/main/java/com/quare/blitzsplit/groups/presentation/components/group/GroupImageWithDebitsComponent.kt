package com.quare.blitzsplit.groups.presentation.components.group

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.quare.blitzsplit.groups.domain.model.UserDebitsModel

@Composable
fun GroupImageWithDebitsComponent(
    name: String,
    imageUrl: String?,
    userDebits: UserDebitsModel,
    imageSize: Dp,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        GroupCardItemImage(
            modifier = Modifier.size(imageSize),
            name = name,
            imageUrl = imageUrl
        )
        if (userDebits.shouldShow) {
            UserDebitsAmountComponent(
                modifier = Modifier.padding(8.dp),
                amount = userDebits.amount
            )
        }
    }
}
