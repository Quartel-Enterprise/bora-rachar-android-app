package com.quare.blitzsplit.groups.presentation.components.group

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.quare.blitzplit.component.chip.price.PricesChipsComponent
import com.quare.blitzsplit.groups.domain.model.GroupsScreenItem

@Composable
fun GroupChipsComponent(
    data: GroupsScreenItem.GroupItem,
    modifier: Modifier = Modifier,
) {
    when (data) {
        is GroupsScreenItem.GroupItem.WithDebits -> PricesChipsComponent(
            modifier = modifier,
            priceChipsModel = data.priceChipsModel
        )
        is GroupsScreenItem.GroupItem.PaidOff -> PaidOffChipComponent(modifier)
    }
}
