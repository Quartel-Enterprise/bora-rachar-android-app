package com.quare.blitzsplit.groups.domain.usecase

import com.quare.blitzsplit.groups.domain.model.GroupsScreenItem
import com.quare.blitzsplit.groups.domain.repository.GroupsRepository
import com.quare.blitzsplit.groups.presentation.viewmodel.GroupsUiState
import javax.inject.Inject

class GetGroupsUiStateUseCase @Inject constructor(
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
                space = CREATE_GROUP_AT_TOP_SPACE
            ) + withDebitGroups + paidOffGroupsTitle + paidOffGroups
        } else {
            withDebitGroups + paidOffGroupsTitle + paidOffGroups + getCreateGroupButton(
                space = CREATE_GROUP_AT_BOTTOM_SPACE
            )
        }
    }

    private fun getCreateGroupButton(
        space: Int,
    ): List<GroupsScreenItem.CreateGroupButtonModel> = listOf(
        GroupsScreenItem.CreateGroupButtonModel(space)
    )

    companion object {
        private const val CREATE_GROUP_AT_TOP_SPACE = 0
        private const val CREATE_GROUP_AT_BOTTOM_SPACE = 8
    }
}
