package com.quare.blitzsplit.groups

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.quare.blitzplit.component.mainappbar.domain.MainAppBarModel
import com.quare.blitzplit.component.mainappbar.presentaiton.MainAppBar

@Composable
fun GroupsScreen(
//    groupsViewModel: GroupsViewModel = viewModel(), // TODO fix crash when creating view model
    onPhotoClick: () -> Unit,
) {
//    val groupsUiState by groupsViewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MainAppBar(
                data = MainAppBarModel(
                    photoUrl = null,
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
