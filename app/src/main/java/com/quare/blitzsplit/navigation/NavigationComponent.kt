package com.quare.blitzsplit.navigation

import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.quare.blitzsplit.login.presentation.LoginScreen
import com.quare.blitzsplit.login.presentation.signin.GoogleAuthUiClient
import com.quare.blitzsplit.login.presentation.viewmodel.LoginViewModel
import com.quare.blitzsplit.groups.presentation.GroupsScreen
import kotlinx.coroutines.launch

@Composable
fun LifecycleOwner.NavigationComponent(
    loginViewModel: LoginViewModel,
    googleAuthUiClient: GoogleAuthUiClient
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginDealer(
                googleAuthUiClient = googleAuthUiClient,
                loginViewModel = loginViewModel,
                onNextScreen = {
                    navController.navigate("groups") {
                        popUpTo(0)
                    }
                }
            )
        }
        composable("groups") {
            GroupsScreen(
                photoUrl = googleAuthUiClient.getSignedInUser()?.profilePictureUrl,
                onPhotoClick = {
                    lifecycleScope.launch {
                        googleAuthUiClient.signOut()
                        loginViewModel.onLogout()
                    }
                    navController.navigate("login") {
                        popUpTo(0)
                    }
                }
            )
        }
    }
}

@Composable
private fun LifecycleOwner.LoginDealer(
    googleAuthUiClient: GoogleAuthUiClient,
    loginViewModel: LoginViewModel,
    onNextScreen: () -> Unit
) {
    val state by loginViewModel.state.collectAsStateWithLifecycle()
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartIntentSenderForResult(),
        onResult = { result ->
            if (result.resultCode == ComponentActivity.RESULT_OK) {
                lifecycleScope.launch {
                    val signResult = googleAuthUiClient.signInWithIntent(
                        intent = result.data ?: return@launch
                    )
                    loginViewModel.onSignInResult(signResult)
                }
            }
        }
    )
    LoginScreen(
        onLogin = {
            lifecycleScope.launch {
                googleAuthUiClient.signIn()?.let { intentSender ->
                    val intentSenderRequest = IntentSenderRequest.Builder(intentSender).build()
                    launcher.launch(intentSenderRequest)
                }
            }
        },
        onNextScreen = onNextScreen,
        state = state
    )
}
