package com.quare.blitzsplit.main.domain.model

import com.quare.blitzsplit.main.domain.usecase.GetInitialPayModalStateUseCase
import com.quare.blitzsplit.main.domain.usecase.GetInitialReceiveModalStateUseCase
import com.quare.blitzsplit.main.domain.usecase.GetMainAppBarModelUseCase
import com.quare.blitzsplit.main.domain.usecase.LogoutUseCase
import javax.inject.Inject

data class MainScreenUseCases @Inject constructor(
    val logout: LogoutUseCase,
    val getPayModalState: GetInitialPayModalStateUseCase,
    val getReceiveModalState: GetInitialReceiveModalStateUseCase,
    val getMainAppBarModel: GetMainAppBarModelUseCase
)
