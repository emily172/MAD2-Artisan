package ie.setu.artisan1.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel : ViewModel() {
    private val auth = FirebaseAuth.getInstance()

    fun login(email: String, password: String, onResult: (Boolean, String?) -> Unit) {
        try {
            if (email.isEmpty() || password.isEmpty()) {
                onResult(false, "Email and password cannot be empty.")
                return
            }

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        onResult(true, null)
                    } else {
                        val errorMessage = task.exception?.localizedMessage ?: "Unknown error"
                        onResult(false, errorMessage) // ✅ Properly handle login errors
                    }
                }
        } catch (e: Exception) {
            onResult(false, "Login failed: ${e.message}") // ✅ Prevent unexpected crashes
        }
    }

    fun register(email: String, password: String, onResult: (Boolean, String?) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onResult(true, null)
                } else {
                    onResult(false, task.exception?.message)
                }
            }
    }

    fun logout() {
        auth.signOut()
    }

    fun isUserLoggedIn(): Boolean {
        return auth.currentUser != null
    }
}


