package com.quare.blitzsplit.main.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.quare.blitzplit.component.mainappbar.presentaiton.MainAppBarComponent
import com.quare.blitzplit.component.navbar.BottomNavBarComponent
import com.quare.blitzplit.component.splitbill.SplitBillButton
import com.quare.blitzsplit.activities.presentation.ActivitiesScreen
import com.quare.blitzsplit.contacts.ContactsScreen
import com.quare.blitzsplit.groups.presentation.GroupsScreen
import com.quare.blitzsplit.groups.presentation.viewmodel.GroupsViewModel
import com.quare.blitzsplit.main.domain.model.MainScreenCallbacks
import com.quare.blitzsplit.main.presentation.component.dialog.MainScreenDialog
import com.quare.blitzsplit.main.presentation.component.mainappbar.MainAppBarState
import com.quare.blitzsplit.main.presentation.component.mainappbar.MainAppBarViewModel
import com.quare.blitzsplit.main.presentation.component.mainappbar.MainScreenAction
import com.quare.blitzsplit.main.presentation.component.navbar.BottomNavBarViewModel
import com.quare.blitzsplit.main.presentation.component.navbar.BottomNavScreen

@Composable
fun MainScreen(
    callbacks: MainScreenCallbacks,
    mainAppBarViewModel: MainAppBarViewModel = hiltViewModel(),
    bottomBarViewModel: BottomNavBarViewModel = hiltViewModel(),
    groupsViewModel: GroupsViewModel = hiltViewModel(),
) {
    val mainAppBarState by mainAppBarViewModel.state.collectAsStateWithLifecycle()
    val bottomBarState by bottomBarViewModel.state.collectAsStateWithLifecycle()
    val groupsState by groupsViewModel.state.collectAsStateWithLifecycle()

    val successMainAppBarState = mainAppBarState as? MainAppBarState.Success

    successMainAppBarState?.currentDialog?.let { currentDialog ->
        MainScreenDialog(
            dialogType = currentDialog,
            onLogout = mainAppBarViewModel::onClickLogout,
            onDismiss = mainAppBarViewModel::onDismissDialog
        )
    }

    LaunchedEffect(key1 = Unit) {
        mainAppBarViewModel.action.collect { action ->
            when (action) {
                MainScreenAction.BACK_TO_LOGIN -> callbacks.backToLogin()
            }
        }
    }

    Scaffold(
        topBar = {
            successMainAppBarState?.let {
                MainAppBarComponent(
                    data = it.mainAppBarModel,
                    priceChipsClicks = it.priceChipsClicks,
                    onPhotoClick = mainAppBarViewModel::onProfilePictureClick
                )
            } ?: run {
                // TODO: render loading state for this app bar
            }
        },
        floatingActionButton = {
            SplitBillButton(onClick = callbacks.splitBillClick)
        },
        bottomBar = {
            BottomNavBarComponent(bottomBarState.items)
        }
    ) { paddingValues ->
        val modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
        when (bottomBarState.selectedScreen) {
            BottomNavScreen.GROUPS -> GroupsScreen(
                modifier = modifier,
                createGroupClick = callbacks.createGroupClick,
                uiState = groupsState,
                onGroupClick = callbacks.onGroupClick
            )
            BottomNavScreen.CONTACTS -> ContactsScreen(modifier)
            BottomNavScreen.ACTIVITY -> ActivitiesScreen(modifier)
        }
    }
}
