package presentaiton.viewmodel

import domain.model.GroupDetailsModel
import domain.model.GroupDialog

sealed interface GroupUiState {

    data class Success(
        val model: GroupDetailsModel,
        val currentDialog: GroupDialog?,
    ): GroupUiState

    data object Loading: GroupUiState
}
