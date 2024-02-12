package com.quare.blitzplit.component.dialog.bill

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quare.blitzplit.component.dialog.DialogComponent
import com.quare.blitzplit.component.dialog.bill.model.BillDialogColouredTextModel
import com.quare.blitzplit.component.spacer.VerticalSpacer
import com.quare.blitzsplit.theme.BlitzSplitTheme

@Composable
fun BillDialog(
    title: String,
    onConfirmButtonClick: () -> Unit,
    onDismiss: () -> Unit,
    middleContent: @Composable (() -> Unit),
    onRevertButtonClick: () -> Unit,
    mustShowRevertButton: Boolean,
    textInfo: BillDialogColouredTextModel,
) {
    DialogComponent(
        title = title,
        confirmButtonText = "Concluído",
        cancelButtonText = "Reverter".takeIf { mustShowRevertButton },
        confirmButtonClick = onConfirmButtonClick,
        cancelButtonClick = onRevertButtonClick,
        onDismiss = onDismiss,
        middleContent = {
            Column {
                TextBillDescription(textInfo)
                VerticalSpacer(24.dp)
                middleContent()
            }
        }
    )
}

@Composable
@Preview
fun BillDialogPreview() {
    BlitzSplitTheme {
        BillDialog(
            title = "A Pagar",
            onConfirmButtonClick = {},
            onDismiss = {},
            middleContent = {
                Text(text = "Middle Content")
            },
            onRevertButtonClick = {},
            mustShowRevertButton = true,
            textInfo = BillDialogColouredTextModel.Pay(
                usersAmount = 3,
                currencyText = "R$ 9,90"
            ),
        )
    }
}
