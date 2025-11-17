package com.example.project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project.databinding.ActivityHomeScreenBinding

class HomeScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "Home screen ready")
        Toast.makeText(this, R.string.home_greeting, Toast.LENGTH_SHORT).show()

        intent.getStringExtra("habit_name")?.let { habitName ->
            val message = getString(R.string.habit_saved, habitName)
            Log.d(TAG, "Returned from creation: $habitName")
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        binding.cardTodayStats.setOnClickListener {
            Log.i(TAG, "Stats card tapped")
            Toast.makeText(this, R.string.keep_it_up, Toast.LENGTH_SHORT).show()
        }

        binding.cardCreateHabit.setOnClickListener {
            Log.d(TAG, "Taking user to create habit")
            startActivity(Intent(this, CreateHabitActivity::class.java))
        }

        binding.cardGoToTabs.setOnClickListener {
            Log.d(TAG, "Opening five-tab experience")
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.cardProfile.setOnClickListener {
            Log.d(TAG, "Opening profile")
            startActivity(Intent(this, ProfileScreenActivity::class.java))
        }
    }

    companion object {
        private const val TAG = "HomeScreenActivity"
    }
}

