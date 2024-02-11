package com.quare.blitzsplit.groups.domain.usecase

import com.quare.blitzsplit.groups.domain.model.GroupsScreenItem
import com.quare.blitzsplit.groups.domain.repository.GroupsRepository
import com.quare.blitzsplit.groups.presentation.viewmodel.GroupsUiState

class GetGroupsUiStateUseCase(
    private val groupsRepository: GroupsRepository,
) {
    suspend operator fun invoke(): GroupsUiState =
        groupsRepository.getGroups().getOrNull()?.let { groups ->
            val isCreateGroupAtTop = groups.size > 3 /* TODO: improve this logic based on number of
            groups in screen depending on screen size */
            GroupsUiState.Success(
                items = getItems(
                    isCreateGroupAtTop = isCreateGroupAtTop,
                    groups = groups
                )
            )
        } ?: GroupsUiState.Error("Error getting groups") // TODO: more specific message

    private fun getItems(
        isCreateGroupAtTop: Boolean,
        groups: List<GroupsScreenItem.GroupItemModel>,
    ): List<GroupsScreenItem> {
        val createGroupsButton = listOf(GroupsScreenItem.CreateGroupButtonModel)
        return if (isCreateGroupAtTop) {
            createGroupsButton + groups
        } else {
            groups + createGroupsButton
        }
    }
}
