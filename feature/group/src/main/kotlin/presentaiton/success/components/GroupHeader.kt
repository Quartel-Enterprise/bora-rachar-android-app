package presentaiton.success.components

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.quare.blitzplit.component.spacer.HorizontalSpacer
import domain.model.HeaderDetailsModel

@Composable
fun GroupHeader(
    headerDetails: HeaderDetailsModel,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        GroupImage(url = headerDetails.photoUrl)
        HorizontalSpacer(12.dp)
        GroupsHeaderPricesChipComponent(
            receiveChip = headerDetails.receiveChip,
            payChip = headerDetails.payChip
        )
    }
}
