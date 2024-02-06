package com.blitzsplit.login.di

import android.content.Context
import com.blitzsplit.login.presentation.signin.GoogleAuthUiClient
import com.google.android.gms.auth.api.identity.Identity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ActivityComponent::class)
object LoginModule {
    @Provides
    fun providedGoogleAuthenticationClient(
        @ApplicationContext context: Context,
    ): GoogleAuthUiClient = GoogleAuthUiClient(Identity.getSignInClient(context))
}
