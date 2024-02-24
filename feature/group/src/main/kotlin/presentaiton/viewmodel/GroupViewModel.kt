package presentaiton.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quare.blitzplit.component.chip.price.PriceChipsClicks
import dagger.hilt.android.lifecycle.HiltViewModel
import domain.usecase.GetGroupDetailsUseCase
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class GroupViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getGroupDetails: GetGroupDetailsUseCase
): ViewModel() {

    private val _uiState: MutableStateFlow<GroupUiState> = MutableStateFlow(GroupUiState.Loading)
    val uiState: StateFlow<GroupUiState> = _uiState

    init {
        val id = savedStateHandle.get<String>("groupId") /* TODO: make a request to backend asking
        the group details */
        Log.d("GroupViewModel", id.toString())
        viewModelScope.launch {
            _uiState.update {
                GroupUiState.Success(
                    model = getGroupDetails(
                        clicks = PriceChipsClicks(
                            toPay = {},
                            toReceive = {}
                        )
                    ),
                    currentDialog = null
                )
            }
        }
    }
}
