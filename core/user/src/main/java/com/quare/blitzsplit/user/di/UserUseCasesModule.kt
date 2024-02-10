package com.quare.blitzsplit.user.di

import com.quare.blitzsplit.user.domain.usecase.ClearLocalUser
import com.quare.blitzsplit.user.domain.usecase.GetUserModel
import com.quare.blitzsplit.user.domain.usecase.impl.ClearLocalUserUseCase
import com.quare.blitzsplit.user.domain.usecase.impl.GetUserModelUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UserUseCasesModule {

    @Binds
    abstract fun bindGetUserModel(
        getUserModelUseCase: GetUserModelUseCase
    ): GetUserModel

    @Binds
    abstract fun bindClearLocalUser(
        clearLocalUserUseCase: ClearLocalUserUseCase
    ): ClearLocalUser
}
