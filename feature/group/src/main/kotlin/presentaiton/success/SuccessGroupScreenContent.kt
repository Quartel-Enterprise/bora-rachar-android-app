package presentaiton.success

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quare.blitzplit.component.appbar.AppBar
import com.quare.blitzplit.component.utils.StaticImages
import com.quare.blitzsplit.theme.BlitzSplitTheme
import domain.model.GroupDetailsModel
import domain.model.HeaderDetailsModel
import domain.model.HeaderPriceModel
import presentaiton.success.components.GroupHeader

@Composable
fun SuccessGroupScreenContent(
    groupDetails: GroupDetailsModel,
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            AppBar(
                title = groupDetails.title,
                actionIcon = Icons.Default.MoreVert,
                actionIconDescription = "Mais opções",
                actionIconClick = { },
                backClick = onBack
            )
        }
    ) { paddingValues ->
        LazyColumn(modifier = modifier.padding(paddingValues)) {
            item {
                GroupHeader(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    headerDetails = groupDetails.header
                )
            }
        }
    }
}

@Composable
@Preview
fun SuccessGroupScreenContentPreview() {
    BlitzSplitTheme {
        SuccessGroupScreenContent(
            onBack = {},
            groupDetails = GroupDetailsModel(
                title = "Quartel Otaku",
                header = HeaderDetailsModel(
                    photoUrl = StaticImages.DOG,
                    receiveChip = HeaderPriceModel.Receive(
                        text = "Pagar R$ 9.90 a 3 membros",
                        onClick = {}
                    ),
                    payChip = HeaderPriceModel.Pay(
                        text = "Receber R$ 250 de Pierre V.",
                        onClick = {}
                    )
                )
            )
        )
    }
}
