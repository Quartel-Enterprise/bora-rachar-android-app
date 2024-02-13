package com.quare.blitzplit.component.chip.bill

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quare.blitzplit.component.chip.ChipComponent
import com.quare.blitzsplit.theme.BlitzSplitTheme

@Composable
fun BillChipComponent(
    color: BillChipBackgroundColor,
    buttonText: String,
    onClick: () -> Unit,
) {
    ChipComponent(
        value = buttonText,
        color = color.value,
        paddingValues = PaddingValues(horizontal = 14.5.dp, vertical = 2.dp),
        fontSize = 12.sp,
        onClick = onClick
    )
}

@Composable
@Preview
fun BillDialogButtonPayPreview() {
    BlitzSplitTheme {
        BillChipComponent(
            color = BillChipBackgroundColor.ACTIVE,
            buttonText = "Paguei",
            onClick = {}
        )
    }
}
