package com.quare.blitzsplit.navigation.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.quare.blitzplit.component.mainappbar.presentaiton.MainAppBarComponent
import com.quare.blitzplit.component.navbar.BottomNavBarComponent
import com.quare.blitzsplit.navigation.MainScreenData

@Composable
fun MainScreen(
    data: MainScreenData,
    content: @Composable BoxScope.() -> Unit,
) {
    data.run {
        Scaffold(
            topBar = {
                MainAppBarComponent(
                    data = appBarModel,
                    onClickToPay = callbacks.onClickToPay,
                    onClickToReceive = callbacks.onClickToReceive,
                    onPhotoClick = callbacks.onPhotoClick
                )
            },
            bottomBar = {
                BottomNavBarComponent(navigationItems)
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                content()
            }
        }
    }
}
