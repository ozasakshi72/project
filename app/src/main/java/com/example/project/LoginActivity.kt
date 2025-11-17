package com.example.project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val source = intent.getStringExtra(LogicScreenActivity.EXTRA_PATH_SOURCE)
        Log.d(TAG, "Login opened from: $source")

        binding.btnSignIn.setOnClickListener {
            Log.i(TAG, "Attempting sign in")
            Toast.makeText(this, R.string.auth_login_success, Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, HomeScreenActivity::class.java))
        }

        binding.tvGoRegister.setOnClickListener {
            Log.d(TAG, "Navigating to register screen")
            startActivity(Intent(this, RegisterScreenActivity::class.java))
        }
    }

    companion object {
        private const val TAG = "LoginActivity"
    }
}
