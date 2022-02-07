package com.felipevelez.salesmanagementproject

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.felipevelez.salesmanagementproject.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var registerBinding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)

        with(registerBinding) {
            registerButton.setOnClickListener {
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()
                val repPassword = repPasswordEditText.text.toString()

                if (email.isEmpty() or password.isEmpty() or repPassword.isEmpty()) {
                    Toast.makeText(
                        applicationContext,
                        "Por favor llene todos los campos",
                        Toast.LENGTH_SHORT
                    ).show()
                } else
                    if (password.length < 6) { Toast.makeText(applicationContext, "Las contraseñas debe tener mínimo 6 caracteres", Toast.LENGTH_SHORT).show()
                    } else
                        if (password.equals(repPassword)) {
                            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                            intent.putExtra("email", email)
                            intent.putExtra("password", password)
                            startActivity(intent)
                        } else
                            Toast.makeText(applicationContext, "Las contraseñas deben ser iguales", Toast.LENGTH_SHORT).show()


            }
        }
    }
}