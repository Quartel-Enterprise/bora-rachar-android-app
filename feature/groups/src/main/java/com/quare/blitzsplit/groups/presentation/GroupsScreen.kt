package com.quare.blitzsplit.groups.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quare.blitzsplit.groups.presentation.viewmodel.GroupsUiState
import com.quare.blitzsplit.theme.BlitzSplitTheme

@Composable
fun GroupsScreen(
    uiState: GroupsUiState,
    onGroupClick: (id: String) -> Unit,
    createGroupClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        (uiState as? GroupsUiState.Success)?.let { state ->
            SuccessGroupsScreen(
                items = state.items,
                onGroupClick = onGroupClick,
                createGroupClick = createGroupClick,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun GroupsScreenPreview() {
    BlitzSplitTheme {
        GroupsScreen(
            createGroupClick = {},
            uiState = GroupsUiState.Loading,
            onGroupClick = {}
        )
    }
}
