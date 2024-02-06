package com.quare.blitzsplit.login.di

import android.content.Context
import com.google.android.gms.auth.api.identity.Identity
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.quare.blitzsplit.login.domain.usecase.GetUserDataUseCase
import com.quare.blitzsplit.login.domain.usecase.LogoutUseCase
import com.quare.blitzsplit.login.presentation.signin.GoogleAuthUiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object LoginModule {

    private val auth = Firebase.auth

    @Provides
    fun providesGoogleAuthenticationClient(
        @ApplicationContext context: Context,
    ): GoogleAuthUiClient = GoogleAuthUiClient(
        oneTapClient = Identity.getSignInClient(context),
        auth = auth
    )

    @Provides fun providesGetUserDataUseCase(): GetUserDataUseCase = GetUserDataUseCase(auth)

    @Provides fun providesLogoutUseCase(): LogoutUseCase = LogoutUseCase(auth)
}
