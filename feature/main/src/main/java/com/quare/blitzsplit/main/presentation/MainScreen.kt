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
import com.quare.blitzsplit.main.presentation.component.MainAppBarComponent
import com.quare.blitzsplit.main.presentation.component.navbar.BottomNavBarComponent
import com.quare.blitzsplit.main.presentation.component.SplitBillButton
import com.quare.blitzsplit.activities.presentation.ActivitiesScreen
import com.quare.blitzsplit.contacts.ContactsScreen
import com.quare.blitzsplit.groups.presentation.GroupsScreen
import com.quare.blitzsplit.groups.presentation.viewmodel.GroupsViewModel
import com.quare.blitzsplit.main.domain.model.MainScreenCallbacks
import com.quare.blitzsplit.main.presentation.component.dialog.MainScreenDialog
import com.quare.blitzsplit.main.presentation.viewmodel.MainAppBarState
import com.quare.blitzsplit.main.presentation.viewmodel.MainScreenViewModel
import com.quare.blitzsplit.main.presentation.viewmodel.MainScreenAction
import com.quare.blitzsplit.main.presentation.viewmodel.bottom.BottomNavBarViewModel
import com.quare.blitzsplit.main.presentation.component.navbar.model.BlitzSplitNavType

@Composable
fun MainScreen(
    callbacks: MainScreenCallbacks,
    mainScreenViewModel: MainScreenViewModel = hiltViewModel(),
    bottomBarViewModel: BottomNavBarViewModel = hiltViewModel(),
    groupsViewModel: GroupsViewModel = hiltViewModel(),
) {
    val mainAppBarState by mainScreenViewModel.state.collectAsStateWithLifecycle()
    val bottomBarState by bottomBarViewModel.state.collectAsStateWithLifecycle()
    val groupsState by groupsViewModel.state.collectAsStateWithLifecycle()

    val successMainAppBarState = mainAppBarState as? MainAppBarState.Success

    successMainAppBarState?.currentDialog?.let { currentDialog ->
        MainScreenDialog(
            dialogType = currentDialog,
            onLogout = mainScreenViewModel::onClickLogout,
            onDismiss = mainScreenViewModel::onDismissDialog
        )
    }

    LaunchedEffect(key1 = Unit) {
        mainScreenViewModel.action.collect { action ->
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
                    onPhotoClick = mainScreenViewModel::onProfilePictureClick
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
            BlitzSplitNavType.GROUPS -> GroupsScreen(
                modifier = modifier,
                createGroupClick = callbacks.createGroupClick,
                uiState = groupsState,
                onGroupClick = callbacks.onGroupClick
            )
            BlitzSplitNavType.CONTACTS -> ContactsScreen(modifier)
            BlitzSplitNavType.ACTIVITY -> ActivitiesScreen(modifier)
        }
    }
}
