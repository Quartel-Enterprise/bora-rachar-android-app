package com.quare.blitzsplit.navigation.domain.usecase

import com.quare.blitzsplit.navigation.presentation.viewmodel.NavigationState
import com.quare.blitzsplit.user.domain.usecase.GetUserModel
import javax.inject.Inject

class GetLoadedNavigationStateUseCase @Inject constructor(
    private val getUser: GetUserModel
) {
    suspend operator fun invoke(): NavigationState = getUser()?.let {
        NavigationState.Loaded.LoggedIn
    } ?: NavigationState.Loaded.LoggedOut
}
