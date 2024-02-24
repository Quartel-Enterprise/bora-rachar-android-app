package com.quare.blitzsplit.main.domain.model

import com.quare.blitzsplit.main.domain.usecase.GetInitialPayModalState
import com.quare.blitzsplit.main.domain.usecase.GetInitialReceiveModalState
import com.quare.blitzsplit.main.domain.usecase.GetMainAppBarModelUseCase
import com.quare.blitzsplit.main.domain.usecase.LogoutUseCase
import javax.inject.Inject

data class MainScreenUseCases @Inject constructor(
    val logout: LogoutUseCase,
    val getPayModalState: GetInitialPayModalState,
    val getReceiveModalState: GetInitialReceiveModalState,
    val getMainAppBarModel: GetMainAppBarModelUseCase
)
