package com.quare.blitzsplit.main.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.quare.blitzplit.component.mainappbar.presentaiton.MainAppBarComponent
import com.quare.blitzplit.component.navbar.BottomNavBarComponent
import com.quare.blitzsplit.groups.GroupsScreen
import com.quare.blitzsplit.main.presentation.component.mainappbar.MainAppBarViewModel
import com.quare.blitzsplit.main.presentation.component.navbar.BottomNavBarViewModel
import com.quare.blitzsplit.main.presentation.component.navbar.BottomNavScreen

@Composable
fun MainScreen(
    backToLogin: () -> Unit,
    mainAppBarViewModel: MainAppBarViewModel = hiltViewModel(),
    bottomBarViewModel: BottomNavBarViewModel = hiltViewModel(),
) {
    val mainAppBarModel by mainAppBarViewModel.state.collectAsStateWithLifecycle()
    val bottomBarState by bottomBarViewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            MainAppBarComponent(
                data = mainAppBarModel,
                onClickToPay = mainAppBarViewModel::onClickToPay,
                onClickToReceive = mainAppBarViewModel::onClickToReceive,
                onPhotoClick = {
                    mainAppBarViewModel.onClickLogout()
                    backToLogin()
                }
            )
        },
        bottomBar = {
            BottomNavBarComponent(bottomBarState.items)
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            GroupsScreen(
                modifier = Modifier.align(Alignment.Center),
                text = when (bottomBarState.selectedScreen) {
                    BottomNavScreen.GROUPS -> "Grupos"
                    BottomNavScreen.CONTACTS -> "Contatos"
                    BottomNavScreen.ACTIVITY -> "Atividades"
                }
            )
        }
    }
}
