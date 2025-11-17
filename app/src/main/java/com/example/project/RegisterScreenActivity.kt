package com.example.project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project.databinding.ActivityRegisterScreenBinding

class RegisterScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "Register screen ready")

        binding.btnRegister.setOnClickListener {
            val email = binding.inputEmail.text?.toString().orEmpty()
            Log.i(TAG, "Register tapped for $email")
            Toast.makeText(this, R.string.auth_register_success, Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, HomeScreenActivity::class.java))
        }
    }

    companion object {
        private const val TAG = "RegisterScreenActivity"
    }
}

