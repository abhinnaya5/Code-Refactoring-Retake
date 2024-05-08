package com.example.kotlintesingunit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button
    private lateinit var usernameField: EditText
    private lateinit var passwordField: EditText
    private lateinit var confirmPasswordField: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        loginButton = findViewById(R.id.buttonLoginNewUser)
        registerButton = findViewById(R.id.buttonRegisterNewUser)
        usernameField = findViewById(R.id.editTextNewUsername)
        passwordField = findViewById(R.id.editTextNewPassword)
        confirmPasswordField = findViewById(R.id.editTextNewConfirmPassword)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        registerButton.setOnClickListener {
            register()
        }

        loginButton.setOnClickListener {
            navigateToLoginActivity()
        }
    }

    private fun register() {
        val toast = CustomToast()
        if (areFieldsEmpty()) {
            toast.showToast(this, "All fields must be filled!")
        } else if (passwordField.text.toString() != confirmPasswordField.text.toString()) {
            toast.showToast(this, "Password must match the confirm password!")
        } else {
            navigateToHomeActivity()
        }
    }

    private fun areFieldsEmpty(): Boolean {
        return usernameField.text.isEmpty() || passwordField.text.isEmpty() || confirmPasswordField.text.isEmpty()
    }

    private fun navigateToHomeActivity() {
        startActivity(Intent(this, HomeActivity::class.java))
    }

    private fun navigateToLoginActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}
