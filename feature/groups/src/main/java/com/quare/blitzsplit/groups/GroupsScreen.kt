package com.quare.blitzsplit.groups

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun BoxScope.GroupsScreen() {
    Text(
        text = "Groups",
        modifier = Modifier.align(Alignment.Center)
    )
}

@Composable
fun BoxScope.ContactsScreen() {
    Text(
        text = "Contacts",
        modifier = Modifier.align(Alignment.Center)
    )
}

@Composable
fun BoxScope.ActivitiesScreen() {
    Text(
        text = "Activities",
        modifier = Modifier.align(Alignment.Center)
    )
}
