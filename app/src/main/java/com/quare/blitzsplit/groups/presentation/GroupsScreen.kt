package com.quare.blitzsplit.groups.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.quare.blitzsplit.groups.domain.MainAppBarModel

@Composable
fun GroupsScreen(
    photoUrl: String?,
    onPhotoClick: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MainAppBar(
                data = MainAppBarModel(
                    photoUrl = photoUrl,
                    balanceReceivable = null,
                    balanceToPay = null,
                ),
                onPhotoClick = onPhotoClick,
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues))
    }
}
