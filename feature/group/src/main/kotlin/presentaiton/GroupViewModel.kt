package presentaiton

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GroupViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    init {
        val id = savedStateHandle.get<String>("groupId") /* TODO: make a request to backend asking
        the group details */
        Log.d("GroupViewModel", id.toString())
    }
}
