package com.quare.blitzsplit.login.presentation.component.notlogged

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quare.blitzplit.component.spacer.VerticalSpacer
import com.quare.blitzsplit.login.R
import com.quare.blitzsplit.theme.BlitzSplitTheme

@Composable
fun LoginContent(
    isLoading: Boolean,
    onLogin: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.bora_rachar_login_initial_page),
            contentDescription = "background login"
        )
        VerticalSpacer(32.dp)
        Logo(modifier = Modifier.fillMaxWidth())
        VerticalSpacer(32.dp)
        Text(
            modifier = Modifier
                .padding(horizontal = 32.dp),
            text = "Divida Experiências Sem Estresse!",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
        VerticalSpacer(64.dp)
        val dynamicModifier = Modifier.fillMaxWidth()
        if (isLoading) {
            GoogleLoginLoading(modifier = dynamicModifier)
        } else {
            LoginWithGoogleButton(
                modifier = dynamicModifier.padding(horizontal = 32.dp),
                onClick = onLogin
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun NotLoggedContentPreview() {
    BlitzSplitTheme {
        LoginContent(
            isLoading = false,
            onLogin = {}
        )
    }
}
