package com.example.project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project.databinding.ActivityLogicScreenBinding

class LogicScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogicScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogicScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "Logic screen created")
        Toast.makeText(this, R.string.welcome_to_habitnest, Toast.LENGTH_SHORT).show()

        binding.btnSignIn.setOnClickListener {
            Log.i(TAG, "Sign in tapped")
            startActivity(
                Intent(this, LoginActivity::class.java).apply {
                    putExtra(EXTRA_PATH_SOURCE, "logic_screen")
                }
            )
        }

        binding.btnRegister.setOnClickListener {
            Log.i(TAG, "Register tapped")
            val intent = Intent(this, RegisterScreenActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        private const val TAG = "LogicScreenActivity"
        const val EXTRA_PATH_SOURCE = "path_source"
    }
}

