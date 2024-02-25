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
        val paidOffGroupsTitle = listOf(GroupsScreenItem.PaidOffGroupsTitle)
        val withDebitGroups = groups.filterIsInstance<GroupsScreenItem.GroupItem.WithDebits>()
        val paidOffGroups = groups.filterIsInstance<GroupsScreenItem.GroupItem.PaidOff>()
        val isCreateGroupAtTop = (withDebitGroups + paidOffGroups).size > 3 /* TODO: improve this
               logic based on number of groups in screen depending on screen size */
        return if (isCreateGroupAtTop) {
            getCreateGroupButton(
                padding = CREATE_GROUP_AT_TOP_PADDING
            ) + withDebitGroups + paidOffGroupsTitle + paidOffGroups
        } else {
            withDebitGroups + paidOffGroupsTitle + paidOffGroups + getCreateGroupButton(
                padding = CREATE_GROUP_AT_BOTTOM_PADDING
            )
        }
    }

    private fun getCreateGroupButton(
        padding: Int,
    ): List<GroupsScreenItem.CreateGroupButtonModel> = listOf(
        GroupsScreenItem.CreateGroupButtonModel(padding)
    )

    companion object {
        private const val CREATE_GROUP_AT_TOP_PADDING = 0
        private const val CREATE_GROUP_AT_BOTTOM_PADDING = 8
    }
}
