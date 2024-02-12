package com.quare.blitzsplit.groups.data.datasource

import com.quare.blitzsplit.groups.domain.model.GroupsScreenItem
import javax.inject.Inject

class RemoteGroupsDataSource @Inject constructor() {
    fun getGroups(): Result<List<GroupsScreenItem>> = Result.failure(
        Throwable("There's no cached data yet.")
    )
}
