package com.quare.blitzsplit.groups.domain.repository

import com.quare.blitzsplit.groups.domain.model.GroupsScreenItem

interface GroupsRepository {
    suspend fun getGroups(): Result<List<GroupsScreenItem.GroupItemModel>>
}
