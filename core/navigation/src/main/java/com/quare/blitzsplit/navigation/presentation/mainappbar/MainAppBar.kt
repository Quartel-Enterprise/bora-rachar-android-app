package com.quare.blitzsplit.navigation.presentation.mainappbar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.quare.blitzplit.component.mainappbar.presentaiton.MainAppBarComponent

@Composable
fun MainAppBar(
    onLogout: () -> Unit,
    mainAppBarViewModel: MainAppBarViewModel = hiltViewModel(),
) {

    val mainAppBarModel by mainAppBarViewModel.state.collectAsStateWithLifecycle()

    MainAppBarComponent(
        data = mainAppBarModel,
        onClickToPay = mainAppBarViewModel::onClickToPay,
        onClickToReceive = mainAppBarViewModel::onClickToReceive,
        onPhotoClick = {
            mainAppBarViewModel.onClickLogout()
            onLogout()
        }
    )
}
