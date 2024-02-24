package com.quare.blitzplit.component.dialog.bill

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quare.blitzplit.component.dialog.bill.model.BillDialogColouredTextModel
import com.quare.blitzplit.component.spacer.VerticalSpacer
import com.quare.blitzsplit.theme.BlitzSplitTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BillBottomSheet(
    title: String,
    onDismiss: () -> Unit,
    middleContent: @Composable (() -> Unit),
    textInfo: BillDialogColouredTextModel,
) {
    ModalBottomSheet(
        onDismissRequest = onDismiss,
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(text = title)
            VerticalSpacer(16.dp)
            TextBillDescription(textInfo)
            VerticalSpacer(24.dp)
            middleContent()
            VerticalSpacer(24.dp)
        }
    }
}

@Composable
@Preview
fun BillDialogPreview() {
    BlitzSplitTheme {
        BillBottomSheet(
            title = "A Pagar",
            onDismiss = {},
            middleContent = {
                Text(text = "Middle Content")
            },
            textInfo = BillDialogColouredTextModel.Pay(
                usersAmount = 3,
                currencyText = "R$ 9,90",
                membersText = "grupo"
            ),
        )
    }
}
