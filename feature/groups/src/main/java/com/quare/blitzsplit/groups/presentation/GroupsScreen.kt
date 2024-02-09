package com.quare.blitzsplit.groups.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quare.blitzsplit.groups.presentation.components.CreateGroupButton
import com.quare.blitzsplit.theme.BlitzSplitTheme

@Composable
fun GroupsScreen(
    createGroupClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier.padding(16.dp)) {
        item {
            CreateGroupButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = createGroupClick
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun GroupsScreenPreview() {
    BlitzSplitTheme {
        GroupsScreen(
            createGroupClick = {}
        )
    }
}
