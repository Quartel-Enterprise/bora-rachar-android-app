package com.quare.blitzsplit.groups

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun GroupsScreen(mainAppBar: @Composable () -> Unit) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = mainAppBar
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues))
    }
}
