package com.quare.blitzsplit.groups.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quare.blitzplit.component.spacer.VerticalSpacer
import com.quare.blitzsplit.groups.domain.model.GroupsScreenItem
import com.quare.blitzsplit.groups.presentation.components.CreateGroupButton
import com.quare.blitzsplit.groups.presentation.components.group.GroupItemComponent
import com.quare.blitzsplit.utils.isLastIndex
import rememberForeverLazyListState

@Composable
internal fun SuccessGroupsScreen(
    items: List<GroupsScreenItem>,
    onGroupClick: (id: String) -> Unit,
    createGroupClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        state = rememberForeverLazyListState(key = "Success Groups Screen")
    ) {
        items.forEachIndexed { index, itemList ->
            item {
                when (itemList) {
                    is GroupsScreenItem.CreateGroupButtonModel -> {
                        VerticalSpacer(itemList.padding.dp)
                        CreateGroupButton(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = createGroupClick
                        )
                    }

                    GroupsScreenItem.PaidOffGroupsTitle -> Text(
                        text = "Grupos Quitados:",
                        fontSize = 16.sp
                    )

                    is GroupsScreenItem.GroupItem -> GroupItemComponent(
                        modifier = Modifier.fillMaxWidth(),
                        data = itemList,
                        onClick = { onGroupClick(itemList.id) }
                    )

                }
                if (!items.isLastIndex(index)) {
                    VerticalSpacer()
                }
            }
        }
    }
}
