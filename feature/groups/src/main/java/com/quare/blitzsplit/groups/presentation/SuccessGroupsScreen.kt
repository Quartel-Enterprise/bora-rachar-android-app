package com.quare.blitzsplit.groups.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.quare.blitzplit.component.spacer.VerticalSpacer
import com.quare.blitzsplit.groups.domain.model.GroupsScreenItem
import com.quare.blitzsplit.groups.presentation.components.CreateGroupButton
import com.quare.blitzsplit.groups.presentation.components.group.GroupItemComponent

@Composable
internal fun SuccessGroupsScreen(
    items: List<GroupsScreenItem>,
    onGroupClick: (id: String) -> Unit,
    createGroupClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val itemsSize = items.size
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items.forEachIndexed { index, itemList ->
            item {
                when (itemList) {
                    GroupsScreenItem.CreateGroupButtonModel -> CreateGroupButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = createGroupClick
                    )
                    is GroupsScreenItem.GroupItemModel -> GroupItemComponent(
                        modifier = Modifier.fillMaxWidth(),
                        data = itemList,
                        onClick = { onGroupClick(itemList.id) }
                    )
                }
                if (index.isNotLast(itemsSize)) {
                    VerticalSpacer()
                }
            }
        }
    }
}

private fun Int.isNotLast(itemsSize: Int): Boolean = this != itemsSize - 1
