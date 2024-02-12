package com.quare.blitzsplit.groups.domain.usecase

import com.quare.blitzsplit.groups.domain.model.GroupsScreenItem
import com.quare.blitzsplit.groups.domain.repository.GroupsRepository
import com.quare.blitzsplit.groups.presentation.viewmodel.GroupsUiState

class GetGroupsUiStateUseCase(
    private val groupsRepository: GroupsRepository,
) {
    suspend operator fun invoke(): GroupsUiState =
        groupsRepository.getGroups().getOrNull()?.let { groups ->
            GroupsUiState.Success(getItems(groups))
        } ?: GroupsUiState.Error("Error getting groups") // TODO: more specific message

    private fun getItems(groups: List<GroupsScreenItem>): List<GroupsScreenItem> {
        val createGroupsButton = listOf(GroupsScreenItem.CreateGroupButtonModel)
        val paidOffGroupsTitle = listOf(GroupsScreenItem.PaidOffGroupsTitle)
        val withDebitGroups = groups.filterIsInstance<GroupsScreenItem.GroupItem.WithDebits>()
        val paidOffGroups = groups.filterIsInstance<GroupsScreenItem.GroupItem.PaidOff>()
        val isCreateGroupAtTop = (withDebitGroups + paidOffGroups).size > 3 /* TODO: improve this
               logic based on number of groups in screen depending on screen size */
        return if (isCreateGroupAtTop) {
            createGroupsButton + withDebitGroups + paidOffGroupsTitle + paidOffGroups
        } else {
            withDebitGroups + paidOffGroupsTitle + paidOffGroups + createGroupsButton
        }
    }
}
