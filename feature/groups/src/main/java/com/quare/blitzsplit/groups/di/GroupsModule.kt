package com.quare.blitzsplit.groups.di

import com.quare.blitzsplit.groups.data.GroupsRepositoryImpl
import com.quare.blitzsplit.groups.data.datasource.LocalGroupsDataSource
import com.quare.blitzsplit.groups.data.datasource.RemoteGroupsDataSource
import com.quare.blitzsplit.groups.domain.repository.GroupsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object GroupsModule {

    @Provides
    fun providesGroupsRepository(
        localGroupsDataSource: LocalGroupsDataSource,
        remoteGroupsDataSource: RemoteGroupsDataSource,
    ): GroupsRepository = GroupsRepositoryImpl(
        localDataSource = localGroupsDataSource,
        remoteDataSource = remoteGroupsDataSource
    )
}
