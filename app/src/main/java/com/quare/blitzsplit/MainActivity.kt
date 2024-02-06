package com.quare.blitzsplit

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.blitzsplit.login.presentation.LoginScreen
import com.blitzsplit.login.presentation.signin.GoogleAuthUiClient
import com.blitzsplit.login.presentation.viewmodel.LoginViewModel
import com.blitzsplit.ui.theme.BlitzSplitTheme
import com.quare.blitzsplit.groups.presentation.GroupsScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var googleAuthUiClient: GoogleAuthUiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlitzSplitTheme {
                val loginViewModel: LoginViewModel = viewModel()
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ) {
                        composable("login") {
                            LoginDealer(
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
            }
        }
    }

    @Composable
    private fun LoginDealer(
        loginViewModel: LoginViewModel,
        onNextScreen: () -> Unit
    ) {
        val state by loginViewModel.state.collectAsStateWithLifecycle()
        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.StartIntentSenderForResult(),
            onResult = { result ->
                if (result.resultCode == RESULT_OK) {
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
}
