package uz.ttpu.composearchlab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SignInRoute(
    viewModel: SignInViewModel = viewModel()
) {
    val uiState by viewModel.uiState

    SignInScreen(
        uiState = uiState,
        onSignIn = viewModel::onSignIn
    )
}

@Composable
fun SignInScreen(
    uiState: SignInUiState,
    onSignIn: (String, String) -> Unit
) {
    var email by rememberSaveable {
        mutableStateOf("")
    }

    var password by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = "Sign In"
        )

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text("Email")
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text("Password")
            },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                onSignIn(email, password)
            },
            enabled = uiState !is SignInUiState.InProgress,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sign In")
        }

        when (uiState) {

            SignInUiState.SignedOut -> {
                Text("Please sign in")
            }

            SignInUiState.InProgress -> {
                CircularProgressIndicator()
            }

            is SignInUiState.Error -> {
                Text(uiState.message)
            }

            is SignInUiState.SignedIn -> {
                Text("Welcome, ${uiState.email}")
            }
        }
    }
}