package com.example.project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val tabs = listOf(
        HabitTab("Drink Water", "Hydrate with 8 glasses today", 75, R.drawable.ic_tab_water),
        HabitTab("Study", "Read 20 pages of a book", 82, R.drawable.ic_tab_study),
        HabitTab("Meditate", "Center yourself for 10 minutes", 60, R.drawable.ic_tab_meditate)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "Main tabs ready")
        renderTab(0)

        val cards = listOf(binding.cardTab1, binding.cardTab2, binding.cardTab3)

        val tabIcons = listOf(binding.iconTab1, binding.iconTab2, binding.iconTab3)
        tabIcons.forEachIndexed { index, button ->
            button.setIconResource(tabs[index].icon)
        }

        val tabLabels = listOf(binding.textTab1, binding.textTab2, binding.textTab3)
        tabLabels.forEachIndexed { index, textView -> textView.text = tabs[index].title }

        cards.forEachIndexed { index, card ->
            card.setOnClickListener {
                Log.i(TAG, "Tab $index selected")
                renderTab(index)
                Toast.makeText(this, getString(R.string.tab_selected, tabs[index].title), Toast.LENGTH_SHORT).show()
            }
        }

        binding.cardActive.setOnClickListener {
            Log.d(TAG, "Active card tapped")
            startActivity(Intent(this, CreateHabitActivity::class.java))
        }
    }

    private fun renderTab(index: Int) {
        val tab = tabs[index]
        binding.textActiveTitle.text = tab.title
        binding.textActiveMessage.text = tab.subtitle
        binding.progressActive.setProgressCompat(tab.progress, true)
        binding.textActivePercent.text = getString(R.string.percent_value, tab.progress)
        binding.imageActiveIcon.setImageResource(tab.icon)

        val cards = listOf(binding.cardTab1, binding.cardTab2, binding.cardTab3)
        val selectedStroke = resources.getDimensionPixelSize(R.dimen.tab_stroke_selected)
        val defaultStroke = resources.getDimensionPixelSize(R.dimen.tab_stroke_default)
        cards.forEachIndexed { idx, card ->
            card.strokeWidth = if (idx == index) selectedStroke else defaultStroke
        }
    }

    private data class HabitTab(
        val title: String,
        val subtitle: String,
        val progress: Int,
        val icon: Int
    )

    companion object {
        private const val TAG = "MainActivity"
    }
}