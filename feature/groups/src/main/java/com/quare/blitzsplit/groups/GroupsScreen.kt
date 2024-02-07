package com.quare.blitzsplit.groups

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.quare.blitzplit.component.mainappbar.domain.MainAppBarModel
import com.quare.blitzplit.component.mainappbar.domain.PriceChipsModel
import com.quare.blitzplit.component.mainappbar.presentaiton.MainAppBar

@Composable
fun GroupsScreen(
    mainAppBarModel: MainAppBarModel,
    onPhotoClick: () -> Unit,
    onClickToPay: () -> Unit,
    onClickToReceive: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MainAppBar(
                data = mainAppBarModel,
                onPhotoClick = onPhotoClick,
                onClickToPay = onClickToPay,
                onClickToReceive = onClickToReceive
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues))
    }
}
