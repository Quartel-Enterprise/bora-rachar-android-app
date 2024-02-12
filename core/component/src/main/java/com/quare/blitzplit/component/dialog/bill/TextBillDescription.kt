package com.quare.blitzplit.component.dialog.bill

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.quare.blitzplit.component.dialog.bill.model.BillDialogColouredTextModel
import com.quare.blitzsplit.theme.Black200
import com.quare.blitzsplit.theme.BlitzSplitTheme

@Composable
fun TextBillDescription(
    data: BillDialogColouredTextModel,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = data.toBillStyle()
    )
}

@Composable
private fun BillDialogColouredTextModel.toBillStyle() =
    buildAnnotatedString {
        val billColor = color.value
        add("Você tem ")
        add(
            text = "$currencyText ",
            color = billColor,
            fontWeight = FontWeight.W500
        )
        add(
            text = infoText,
            color = billColor
        )
        add(" $connectorText")
        add(" $usersAmount ")
        add("\nmembros nas despesas do grupo")
    }

private fun AnnotatedString.Builder.add(
    text: String,
    color: Color = Black200,
    fontWeight: FontWeight = FontWeight.W400,
) {
    withStyle(
        style = SpanStyle(
            color = color,
            fontWeight = fontWeight,
            fontSize = 14.sp,
            letterSpacing = 0.25.sp,
        )
    ) {
        append(text)
    }
}


@Composable
@Preview(showBackground = true)
fun PreviewTextBillDescription() {
    BlitzSplitTheme {
        TextBillDescription(
            data = BillDialogColouredTextModel.Pay(
                usersAmount = 3,
                currencyText = "R$ 9,90"
            )
        )
    }
}
