package com.example.kotlintesingunit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button
    private lateinit var usernameField: EditText
    private lateinit var passwordField: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        loginButton = findViewById(R.id.buttonLoginUser)
        registerButton = findViewById(R.id.buttonRegisterUser)
        usernameField = findViewById(R.id.editTextNewUsername)
        passwordField = findViewById(R.id.editTextNewPassword)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        loginButton.setOnClickListener {
            login()
        }

        registerButton.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun login() {
        val toast = CustomToast()
        if (isFieldsEmpty()) {
            toast.showToast(this, "All fields must be filled!")
        } else {
            val loggedUser = UserModel.login(usernameField.text.toString(), passwordField.text.toString())
            if (loggedUser == null) {
                toast.showToast(this, "Invalid credentials")
            } else {
                navigateToHomeActivity()
            }
        }
    }

    private fun isFieldsEmpty(): Boolean {
        return usernameField.text.isEmpty() || passwordField.text.isEmpty()
    }

    private fun navigateToHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}
