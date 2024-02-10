package com.quare.blitzsplit.user.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.quare.blitzsplit.user.data.datasource.FirebaseUserDataSource
import com.quare.blitzsplit.user.data.datasource.local.LocalUserDataSource
import com.quare.blitzsplit.user.data.datasource.local.UserDataSerializer
import com.quare.blitzsplit.user.data.dto.UserDto
import com.quare.blitzsplit.user.data.repository.UserRepositoryImpl
import com.quare.blitzsplit.user.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserDataModule {

    private val Context.userDataStore: DataStore<UserDto> by dataStore(
        fileName = "user.json",
        serializer = UserDataSerializer
    )

    @Provides
    fun provideFirebaseUserDataSource(): FirebaseUserDataSource =
        FirebaseUserDataSource(Firebase.auth)

    @Provides
    @Singleton
    fun providesUserDataStore(
        @ApplicationContext context: Context,
    ): DataStore<UserDto> = context.userDataStore

    @Provides
    @Singleton
    fun provideLocalUserDataSource(
        dataStore: DataStore<UserDto>,
    ): LocalUserDataSource = LocalUserDataSource(
        dataStore = dataStore
    )

    @Singleton
    @Provides
    fun provideUserRepository(
        localUserDataSource: LocalUserDataSource,
        firebaseUserDataSource: FirebaseUserDataSource,
    ): UserRepository = UserRepositoryImpl(
        localUserDataSource = localUserDataSource,
        firebaseUserDataSource = firebaseUserDataSource
    )
}
