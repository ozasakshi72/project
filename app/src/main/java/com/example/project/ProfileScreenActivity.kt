package com.example.project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project.databinding.ActivityProfileScreenBinding

class ProfileScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "Profile screen loaded")
        Toast.makeText(this, R.string.profile_welcome, Toast.LENGTH_SHORT).show()

        binding.btnShareStreak.setOnClickListener {
            Log.i(TAG, "Sharing streak intent fired")
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, getString(R.string.share_streak_message))
            }
            startActivity(Intent.createChooser(shareIntent, getString(R.string.share_now)))
        }
    }

    companion object {
        private const val TAG = "ProfileScreenActivity"
    }
}

