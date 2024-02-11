package com.quare.blitzsplit.main.presentation.component.navbar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.quare.blitzsplit.main.R
import com.quare.blitzsplit.main.presentation.component.navbar.model.BottomNavigationItem
import com.quare.blitzsplit.theme.BlitzSplitTheme

@Composable
fun BottomNavBarComponent(
    items: List<BottomNavigationItem>,
    modifier: Modifier = Modifier,
) {
    NavigationBar(modifier) {
        items.forEach { item ->
            NavigationBarItem(
                selected = item.isSelected,
                onClick = item.onClick,
                label = {
                    Text(text = item.title)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title
                    )
                },
            )
        }
    }
}

@Composable
@Preview
fun GroupsSelectedComponentPreview() {
    BlitzSplitTheme {
        BottomNavBarComponent(
            items = listOf(
                BottomNavigationItem(
                    title = "Groups",
                    icon = R.drawable.groups_icon,
                    isSelected = true,
                    onClick = {}
                ),
                BottomNavigationItem(
                    title = "Contacts",
                    icon = R.drawable.contacts_icon,
                    isSelected = false,
                    onClick = {}
                ),
                BottomNavigationItem(
                    title = "Activity",
                    icon = R.drawable.activity_icon,
                    isSelected = false,
                    onClick = {}
                ),
            )
        )
    }
}

@Composable
@Preview
fun ContactsSelectedComponentPreview() {
    BlitzSplitTheme {
        BottomNavBarComponent(
            items = listOf(
                BottomNavigationItem(
                    title = "Groups",
                    icon = R.drawable.groups_icon,
                    isSelected = false,
                    onClick = {}
                ),
                BottomNavigationItem(
                    title = "Contacts",
                    icon = R.drawable.contacts_icon,
                    isSelected = true,
                    onClick = {}
                ),
                BottomNavigationItem(
                    title = "Activity",
                    icon = R.drawable.activity_icon,
                    isSelected = false,
                    onClick = {}
                ),
            )
        )
    }
}

@Composable
@Preview
fun ActivitiesSelectedComponentPreview() {
    BlitzSplitTheme {
        BottomNavBarComponent(
            items = listOf(
                BottomNavigationItem(
                    title = "Groups",
                    icon = R.drawable.groups_icon,
                    isSelected = false,
                    onClick = {}
                ),
                BottomNavigationItem(
                    title = "Contacts",
                    icon = R.drawable.contacts_icon,
                    isSelected = false,
                    onClick = {}
                ),
                BottomNavigationItem(
                    title = "Activity",
                    icon = R.drawable.activity_icon,
                    isSelected = true,
                    onClick = {}
                ),
            )
        )
    }
}
