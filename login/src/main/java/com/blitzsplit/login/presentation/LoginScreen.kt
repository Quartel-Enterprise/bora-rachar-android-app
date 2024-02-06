package com.blitzsplit.login.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.blitzsplit.login.presentation.component.notlogged.NotLoggedContent
import com.blitzsplit.login.presentation.viewmodel.LoginState
import com.blitzsplit.ui.theme.BlitzSplitTheme

@Composable
fun LoginScreen(
    state: LoginState,
    onLogin: () -> Unit,
    onNextScreen: () -> Unit,
) {
    val context = LocalContext.current
    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
        when (state) {
            LoginState.NotLogged -> NotLoggedContent(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                onLogin = onLogin
            )

            LoginState.Success -> LaunchedEffect(key1 = Unit) {
                onNextScreen()
            }
            is LoginState.Error -> LaunchedEffect(key1 = Unit) {
                Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun LoginScreenPreview() {
    BlitzSplitTheme {
        LoginScreen(
            state = LoginState.NotLogged,
            onLogin = {},
            onNextScreen = {}
        )
    }
}
