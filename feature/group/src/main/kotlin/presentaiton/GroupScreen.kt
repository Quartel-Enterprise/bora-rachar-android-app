package presentaiton

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import presentaiton.success.SuccessGroupScreenContent
import presentaiton.viewmodel.GroupUiState
import presentaiton.viewmodel.GroupViewModel

@Composable
fun GroupScreen(
    viewModel: GroupViewModel = hiltViewModel(),
    onBack: () -> Unit
) {

    val state by viewModel.uiState.collectAsState()

    (state as? GroupUiState.Success)?.let { successState ->
        successState.currentDialog?.let { currentDialog ->

        }
        SuccessGroupScreenContent(
            modifier = Modifier.fillMaxSize(),
            groupDetails = successState.model,
            onBack = onBack
        )
    }
}
