package com.example.project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project.databinding.ActivityCreateHabitBinding

class CreateHabitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateHabitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateHabitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "Create habit ready")

        binding.btnSaveHabit.setOnClickListener {
            val habit = binding.inputHabitName.text?.toString().orEmpty()
            val schedule = binding.inputHabitSchedule.text?.toString().orEmpty()
            Log.i(TAG, "Habit created: $habit @ $schedule")
            Toast.makeText(this, getString(R.string.habit_saved, habit), Toast.LENGTH_SHORT).show()
            startActivity(
                Intent(this, HomeScreenActivity::class.java).apply {
                    putExtra("habit_name", habit)
                }
            )
            finish()
        }
    }

    companion object {
        private const val TAG = "CreateHabitActivity"
    }
}

