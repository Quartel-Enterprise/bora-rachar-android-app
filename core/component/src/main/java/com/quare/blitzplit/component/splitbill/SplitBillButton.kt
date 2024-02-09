package com.quare.blitzplit.component.splitbill

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quare.blitzplit.component.spacer.HorizontalSpacer
import com.quare.blitzsplit.theme.Black300
import com.quare.blitzsplit.theme.BlitzSplitTheme

@Composable
fun SplitBillButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val text = "Rachar Conta"
    FloatingActionButton(
        modifier = modifier,
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = text,
                tint = Black300
            )
            HorizontalSpacer(12.dp)
            Text(
                text = text,
                color = Black300
            )
        }
    }
}

@Composable
@Preview
fun SplitBillButtonPreview() {
    BlitzSplitTheme {
        SplitBillButton(onClick = {})
    }
}
