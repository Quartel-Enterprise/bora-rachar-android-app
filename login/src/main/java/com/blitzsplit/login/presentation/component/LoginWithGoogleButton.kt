package com.blitzsplit.login.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.blitzsplit.login.R
import com.blitzsplit.ui.component.HorizontalSpacer
import com.blitzsplit.ui.theme.Black100
import com.blitzsplit.ui.theme.BlitzSplitTheme

private const val MESSAGE = "Entrar com Google"

@Composable
fun LoginWithGoogleButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = modifier.height(72.dp),
        shape = RoundedCornerShape(21.dp),
        elevation = ButtonDefaults.buttonElevation(2.dp),
        colors = ButtonDefaults.buttonColors(Color.White),
        onClick = onClick,
    ) {
        Image(
            painter = painterResource(id = R.drawable.google_logo),
            contentDescription = MESSAGE
        )
        HorizontalSpacer(32.dp)
        Text(
            text = MESSAGE,
            style = MaterialTheme.typography.bodyLarge.copy(color = Black100)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun LoginWithGoogleButtonPreview() {
    BlitzSplitTheme {
        LoginWithGoogleButton(onClick = {})
    }
}
