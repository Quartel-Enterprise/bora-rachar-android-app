package presentaiton.success.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quare.blitzplit.component.spacer.HorizontalSpacer
import com.quare.blitzsplit.theme.BlitzSplitTheme
import com.quare.blitzsplit.theme.Orange500

@Composable
fun GroupHeaderPriceButton(
    text: String,
    onClick: () -> Unit,
    color: Color,
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = color)
    ) {
        Text(
            text = text,
            color = Color.White
        )
        HorizontalSpacer(4.dp)
        Icon(
            imageVector = Icons.AutoMirrored.Default.ArrowForward,
            contentDescription = text,
            tint = Color.White
        )
    }
}

@Composable
@Preview
fun GroupHeaderPriceButtonPreview() {
    BlitzSplitTheme {
        GroupHeaderPriceButton(
            text = "Pagar R$ 9.90 a 3 membros",
            onClick = {},
            color = Orange500
        )
    }
}
