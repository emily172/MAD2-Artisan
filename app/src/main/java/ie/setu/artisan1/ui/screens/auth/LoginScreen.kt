package ie.setu.artisan1.ui.screens.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ie.setu.artisan1.ui.viewmodel.AuthViewModel

@Composable
fun LoginScreen(
    navController: NavHostController, // ✅ Pass navController here
    authViewModel: AuthViewModel = hiltViewModel(),
    onLoginSuccess: () -> Unit
)
 {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Login or Register", style = MaterialTheme.typography.titleLarge)

        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        TextField(value = password, onValueChange = { password = it }, label = { Text("Password") })

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            if (email.isNotEmpty() && password.isNotEmpty()) {
                authViewModel.login(email, password) { success, error ->
                    if (success) {
                        errorMessage = null // ✅ Clear previous errors

                        println("✅ Login successful! Navigating to RecordScreen...") // 🔍 Debug check

                        // ✅ Simplified navigation (no popUpTo, no complexity)
                        navController.navigate("record_screen")
                    } else {
                        errorMessage = error ?: "Login failed. Please try again."
                    }
                }
            } else {
                errorMessage = "Email and Password cannot be empty."
            }
        }) {
            Text("Login")
        }




        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            if (email.isNotEmpty() && password.isNotEmpty()) {
                authViewModel.register(email, password) { success, error ->
                    if (success) onLoginSuccess()
                    else errorMessage = error
                }
            } else {
                errorMessage = "Email and Password cannot be empty."
            }
        }) {
            Text("Register")
        }


        errorMessage?.let {
            Text(it, color = MaterialTheme.colorScheme.error)
        }
    }
}


