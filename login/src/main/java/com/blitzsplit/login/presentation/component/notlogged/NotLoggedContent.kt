package com.blitzsplit.login.presentation.component.notlogged

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
import com.blitzsplit.login.R
import com.blitzsplit.ui.component.VerticalSpacer
import com.blitzsplit.ui.theme.BlitzSplitTheme

@Composable
fun NotLoggedContent(
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
        LoginWithGoogleButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            onClick = onLogin
        )
    }
}

@Composable
@Preview(showBackground = true)
fun NotLoggedContentPreview() {
    BlitzSplitTheme {
        NotLoggedContent(
            onLogin = {}
        )
    }
}
