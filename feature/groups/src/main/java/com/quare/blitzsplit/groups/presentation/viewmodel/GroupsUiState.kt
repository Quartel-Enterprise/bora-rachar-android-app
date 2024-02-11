package com.quare.blitzsplit.groups.presentation.viewmodel

import com.quare.blitzsplit.groups.domain.model.GroupsScreenItem

interface GroupsUiState {

    data class Success(val items: List<GroupsScreenItem>) : GroupsUiState

    object Loading : GroupsUiState

    data class Error(val message: String) : GroupsUiState
}
