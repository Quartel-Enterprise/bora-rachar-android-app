package com.quare.blitzsplit.groups.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quare.blitzplit.component.spacer.HorizontalSpacer
import com.quare.blitzsplit.theme.BlitzSplitTheme
import com.quare.blitzsplit.theme.Blue300

@Composable
fun CreateGroupButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val title = "Criar Grupo"
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Blue300),
        contentPadding = PaddingValues(vertical = 12.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = title
        )
        HorizontalSpacer(12.dp)
        Text(
            text = title,
            fontSize = 14.sp
        )
    }
}

@Composable
@Preview
fun CreateGroupButtonPreview() {
    BlitzSplitTheme {
        CreateGroupButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {}
        )
    }
}
