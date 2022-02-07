package com.felipevelez.salesmanagementproject

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.PatternsCompat
import com.felipevelez.salesmanagementproject.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var loginBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        var emailReceived: String? = ""
        var passwordReceived: String? = ""
        val credentials = intent.extras

        if (credentials != null) {
            emailReceived = credentials.getString("email")
            passwordReceived = credentials.getString("password")
        }

        loginBinding.registerTextView.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        with(loginBinding){
            signInButton.setOnClickListener {
                val  email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()

                fun validateEmail(): Boolean {
                    return PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
                }

                if(email.isEmpty() or password.isEmpty()){
                    Toast.makeText(applicationContext,"Verifique que no haya campos vacíos",Toast.LENGTH_SHORT).show()
                }else{
                    if (!validateEmail()) {
                        Toast.makeText(applicationContext, "El Correo ingresado no es válido", Toast.LENGTH_SHORT).show()
                    }else{
                        if(email ==emailReceived && password == passwordReceived){
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            intent.putExtra("email", email)
                            startActivity(intent)
                        }else{
                            Toast.makeText(applicationContext,"El usuario ó la contraseña son incorrectas",Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            }
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        Toast.makeText(this,"Ten un felíz día",Toast.LENGTH_SHORT).show()
    }
}