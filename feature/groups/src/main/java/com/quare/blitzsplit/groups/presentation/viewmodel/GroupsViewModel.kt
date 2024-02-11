package com.quare.blitzsplit.groups.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quare.blitzsplit.groups.domain.usecase.GetGroupsUiStateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class GroupsViewModel @Inject constructor(
    private val getGroupsUiState: GetGroupsUiStateUseCase,
) : ViewModel() {

    private val _state: MutableStateFlow<GroupsUiState> = MutableStateFlow(GroupsUiState.Loading)
    val state: MutableStateFlow<GroupsUiState> = _state

    init {
        viewModelScope.launch {
            _state.update {
                getGroupsUiState()
            }
        }
    }
}
