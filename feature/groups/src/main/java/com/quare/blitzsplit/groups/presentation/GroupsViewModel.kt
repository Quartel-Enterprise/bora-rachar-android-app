package com.quare.blitzsplit.groups.presentation

import androidx.lifecycle.ViewModel
import com.quare.blitzsplit.login.domain.model.UserData
import com.quare.blitzsplit.login.domain.usecase.GetUserDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class GroupsViewModel @Inject constructor() : ViewModel()
