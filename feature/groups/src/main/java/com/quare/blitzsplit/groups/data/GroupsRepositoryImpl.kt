package com.quare.blitzsplit.groups.data

import com.quare.blitzsplit.groups.data.datasource.LocalGroupsDataSource
import com.quare.blitzsplit.groups.data.datasource.RemoteGroupsDataSource
import com.quare.blitzsplit.groups.domain.model.GroupsScreenItem
import com.quare.blitzsplit.groups.domain.repository.GroupsRepository
import javax.inject.Inject

class GroupsRepositoryImpl @Inject constructor(
    private val localDataSource: LocalGroupsDataSource,
    private val remoteDataSource: RemoteGroupsDataSource,
) : GroupsRepository {

    override suspend fun getGroups(): Result<List<GroupsScreenItem.GroupItemModel>> =
        localDataSource.getGroups().getOrNull()?.let {
            Result.success(it)
        } ?: remoteDataSource.getGroups()
}
